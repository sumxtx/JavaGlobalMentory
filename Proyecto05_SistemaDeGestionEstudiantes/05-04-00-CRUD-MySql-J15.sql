-- CRUD - Create (insertar) - Read (leer) - Update (actualizar) - Delete (eliminar)
-- Listamos los estudiantes (read)
SELECT id_estudiante, nombre, apellido, telefono, email FROM estudiante;
-- Create (insert)
INSERT INTO estudiante(nombre, apellido, telefono, email) VALUES("Juan", "Perez", "55443322", "juan@mail.com" );
-- Update (modificar)
UPDATE estudiante SET nombre = "Juan Carlos", apellido = "Garcia" WHERE id_estudiante = 1;
-- Delete (eliminar)
DELETE FROM estudiante WHERE id_estudiante = 1;
--
ALTER TABLE estudiante AUTO_INCREMENT = 1;
