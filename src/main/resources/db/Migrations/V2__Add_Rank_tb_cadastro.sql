-- V2: Migration para adicionar a coluna de RANK na tabela de cadastro.
ALTER TABLE TB_CADASTRO
ADD COLUMN missoes_concluidas INTEGER;

