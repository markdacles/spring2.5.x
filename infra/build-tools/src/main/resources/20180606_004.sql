CREATE TABLE project (
    project_id serial PRIMARY KEY,
    project character varying(255),
    start_date timestamp without time zone,
    end_date timestamp without time zone
);

CREATE TABLE personnel_project (
    id serial REFERENCES personnel(id),
    project_id serial REFERENCES project(project_id),
    PRIMARY KEY (id, project_id)
);
