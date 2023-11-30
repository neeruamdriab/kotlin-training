CREATE TABLE IF NOT EXISTS acties (
    id BIGSERIAL PRIMARY KEY,
    fondsId BIGSERIAL NOT NULL,
    titel VARCHAR(50),
    omschrijving VARCHAR(255),
    status VARCHAR(20) NOT NULL
);
CREATE TABLE IF NOT EXISTS fondsen (
    id BIGSERIAL PRIMARY KEY,
    naam VARCHAR(50),
    status VARCHAR(255),
    statusToelichting VARCHAR(255),
    voortgang INTEGER NOT NULL,
    voortgangDelta INTEGER NOT NULL,
    kostenOmschrijving VARCHAR(255)
);