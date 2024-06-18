CREATE TABLE NearEarthObject (
    id VARCHAR(255) PRIMARY KEY,
    neo_reference_id VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    nasa_jpl_url VARCHAR(255),
    absolute_magnitude_h FLOAT,
    is_potentially_hazardous_asteroid BOOLEAN,
    is_sentry_object BOOLEAN
);

