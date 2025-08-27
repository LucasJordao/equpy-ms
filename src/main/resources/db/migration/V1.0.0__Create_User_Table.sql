CREATE TABLE tb_users (
  id UUID PRIMARY KEY,
  name VARCHAR(150) NOT NULL,
  email VARCHAR(255) NOT NULL UNIQUE,
  contact VARCHAR(50),
  document VARCHAR(40),
  password VARCHAR(255) NOT NULL,
  profile VARCHAR(255),
  birth_date DATE,
  roles TEXT[],
  created_at TIMESTAMP NOT NULL DEFAULT NOW(),
  updated_at TIMESTAMP NOT NULL DEFAULT NOW(),
  deleted_at TIMESTAMP
);

COMMENT ON COLUMN tb_users.id IS 'Unique identifier of the user (UUID)';
COMMENT ON COLUMN tb_users.name IS 'User name';
COMMENT ON COLUMN tb_users.email IS 'User email';
COMMENT ON COLUMN tb_users.password IS 'User password (hash)';
COMMENT ON COLUMN tb_users.contact IS 'User contact information';
COMMENT ON COLUMN tb_users.created_at IS 'Date and time of user creation';
COMMENT ON COLUMN tb_users.updated_at IS 'Date and time of user update';
COMMENT ON COLUMN tb_users.profile IS 'User profile image';
COMMENT ON COLUMN tb_users.birth_date IS 'User birth date';
COMMENT ON COLUMN tb_users.roles IS 'List of user roles (list of strings)';
COMMENT ON COLUMN tb_users.deleted_at IS 'Date and time of user deletion';