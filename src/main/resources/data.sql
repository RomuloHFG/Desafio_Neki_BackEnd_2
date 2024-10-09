-- Inserir dados na tabela Specialty (Especialidades)
INSERT INTO Specialty (name) VALUES
('Cardiologia'),
('Radiologia'),
('Dentista'),
('Pediatria'),
('Oftalmologia'),
('Psiquiatria'),
('Ginecologia e Obstetrícia'),
('Ortopedia'),
('Neurologia'),
('Urologia') ON CONFLICT(name) DO NOTHING;

-- Inserir dados na tabela NivelDeAtuacao (Níveis de Atuação)
INSERT INTO Level_Of_Expertise (name) VALUES
('Tecnólogo'),
('Assistente'),
('Estagiário'),
('Especialista'),
('Trainee'),
('Consultor'),
('Coordenador'),
('Pesquisador'),
('Professor') ON CONFLICT(name) DO NOTHING;


-- Inserir dados na tabela Specialty (Especialidades)
-- INSERT IGNORE INTO Specialty (name) VALUES
-- ('Cardiologia'),
-- ('Radiologia'),
-- ('Dentista'),
-- ('Pediatria'),
-- ('Oftalmologia'),
-- ('Psiquiatria'),
-- ('Ginecologia e Obstetrícia'),
-- ('Ortopedia'),
-- ('Neurologia'),
-- ('Urologia');
--
-- -- Inserir dados na tabela NivelDeAtuacao (Níveis de Atuação)
-- INSERT IGNORE INTO Level_Of_Expertise (name) VALUES
-- ('Tecnólogo'),
-- ('Assistente'),
-- ('Estagiário'),
-- ('Especialista'),
-- ('Trainee'),
-- ('Consultor'),
-- ('Coordenador'),
-- ('Pesquisador'),
-- ('Professor');
