USE inventario_2025;

-- procedure probado
DELIMITER //
CREATE PROCEDURE sp_generar_pedido_y_detalle(
IN id_usuario_param INT,
IN id_producto_param INT,
IN cantidad_param INT)
BEGIN
	DECLARE id_pedido INT;
	DECLARE precio DECIMAL(10,2);
	DECLARE total DECIMAL(10,2);
	DECLARE stock_actual INT;
	
		DECLARE EXIT HANDLER FOR SQLEXCEPTION
		BEGIN
			ROLLBACK;
		END;
        
        START TRANSACTION;
		
        SELECT p.cantidad, p.precio INTO stock_actual, precio FROM producto p WHERE id_producto = id_producto_param;
		
        SET total = precio*cantidad_param;

        IF stock_actual <cantidad_param THEN
			SIGNAL SQLSTATE '45000'
			SET MESSAGE_TEXT = 'Stock insuficiente para realizar el pedido';
		END IF;
        
		INSERT INTO pedido(usuario_id, fecha_pedido, estado)
		VALUES (id_usuario_param,NOW(),'PENDIENTE');
		
		SET id_pedido = LAST_INSERT_ID();
		
		INSERT INTO detalle_pedido(cantidad, precio_unitario,pedido_id, producto_id, precio_total)
		VALUES (cantidad_param, precio, id_pedido,id_producto_param, total);
		
		UPDATE producto
		SET cantidad = cantidad - cantidad_param WHERE id_producto = id_producto_param;
        
        COMMIT;
END //
DELIMITER ;

-- procedure probado
DELIMITER //
CREATE PROCEDURE sp_obtener_pedidos_usuario
(IN id_usuario_param INT)
BEGIN
	SELECT * FROM pedido WHERE usuario_id = id_usuario_param;
END//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE sp_cancelar_pedido
(IN id_pedido_param INT)
BEGIN
	DECLARE id_producto_var INT;
    DECLARE stock_restaurar INT;
    
	UPDATE pedido
    SET estado = 'CANCELADO' WHERE id_pedido = id_pedido_param;
    
    SELECT producto_id, cantidad INTO id_producto_var, stock_restaurar FROM detalle_pedido WHERE pedido_id = id_pedido_param ;
    SELECT * FROM producto;
    UPDATE producto
    SET cantidad = cantidad + stock_restaurar WHERE id_producto = id_producto_var;
END//
DELIMITER ;

CALL sp_cancelar_pedido(3);

