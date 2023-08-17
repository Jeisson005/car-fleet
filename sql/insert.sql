INSERT INTO public.carro (fecha_fabricacion,marca,modelo) VALUES
	 ('2015-01-01 05:00:00.000','Renault','Stepway'),
	 ('2023-01-01 05:00:00.000','Renault','Duster'),
	 ('2018-01-10 05:00:00.000','Hiundai','i35'),
	 ('2013-08-31 05:00:00.000','Chevrolet','Spark');

INSERT INTO public.empleado (matricula,nombre) VALUES
	 (1001,'Jeisson Piñeros'),
	 (2001,'Dayany Vargas'),
	 (3001,'Lucas Ribeiro'),
	 (4001,'Vanessa Piñeros');

INSERT INTO public.viaje (fecha_entrega,fecha_retirada,carro_id,empleado_id) VALUES
	 (NULL,'2023-08-12 08:53:01.411',3,3),
	 ('2023-08-12 08:54:24.714','2023-08-12 08:52:52.935',1,1);
