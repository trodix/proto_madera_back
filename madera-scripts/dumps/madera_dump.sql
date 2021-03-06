--
-- PostgreSQL database dump
--

-- Dumped from database version 10.10
-- Dumped by pg_dump version 10.10

-- Started on 2019-10-16 16:48:01

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 6 (class 2615 OID 24576)
-- Name: madera; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA madera;


ALTER SCHEMA madera OWNER TO postgres;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 198 (class 1259 OID 24582)
-- Name: adresse; Type: TABLE; Schema: madera; Owner: postgres
--

CREATE TABLE madera.adresse (
    i_adresse_id serial,
    v_ville character varying(45),
    v_code_postale character varying(5),
    v_rue character varying(45),
    v_complement character varying(45),
    v_numero character varying(5)
);


ALTER TABLE madera.adresse OWNER TO postgres;

--
-- TOC entry 197 (class 1259 OID 24577)
-- Name: client; Type: TABLE; Schema: madera; Owner: postgres
--

CREATE TABLE madera.client (
    i_client_id serial,
    v_nom character varying(45),
    v_prenom character varying(45),
    v_tel character varying(10),
    v_mail character varying(45)
);


ALTER TABLE madera.client OWNER TO postgres;

--
-- TOC entry 213 (class 1259 OID 24773)
-- Name: client_adresse; Type: TABLE; Schema: madera; Owner: postgres
--

CREATE TABLE madera.client_adresse (
    i_client_id integer not null,
    i_adresse_id integer,
    b_adresse_facturation boolean default false
);


ALTER TABLE madera.client_adresse OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 24635)
-- Name: composant; Type: TABLE; Schema: madera; Owner: postgres
--

--TODO Enlever i_stock_id et gérer les stocks dans la table stock ?
CREATE TABLE madera.composant (
    i_composant_id serial,
    i_composant_groupe_id integer,
    v_libelle character varying(45),
    i_composant_referentiel_id integer,
    f_section float NOT NULL,
    f_composant_prix float NOT NULL
);


ALTER TABLE madera.composant OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 24696)
-- Name: composant_fournisseur; Type: TABLE; Schema: madera; Owner: postgres
--

CREATE TABLE madera.composant_fournisseur (
    i_composant_id integer NOT NULL,
    i_fournisseur_id integer NOT NULL,
    v_ref_fournisseur character varying(45) NOT NULL
);


ALTER TABLE madera.composant_fournisseur OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 24625)
-- Name: composant_groupe; Type: TABLE; Schema: madera; Owner: postgres
--

CREATE TABLE madera.composant_groupe (
    i_composant_groupe_id serial,
    v_libelle_groupe character varying(45)
);


ALTER TABLE madera.composant_groupe OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 24630)
-- Name: composant_referentiel; Type: TABLE; Schema: madera; Owner: postgres
--

CREATE TABLE madera.composant_referentiel (
    i_composant_referentiel_id serial,
    v_caracteristique character varying(45),
    v_unite_usage character varying(45)
);


ALTER TABLE madera.composant_referentiel OWNER TO postgres;

--
-- TOC entry 211 (class 1259 OID 24712)
-- Name: devis_etat; Type: TABLE; Schema: madera; Owner: postgres
--

CREATE TABLE madera.devis_etat (
    i_devis_etat_id serial,
    v_devis_etat_libelle character varying(150),
    i_pourcentage_somme integer
);


ALTER TABLE madera.devis_etat OWNER TO postgres;

--
-- TOC entry 199 (class 1259 OID 24587)
-- Name: fournisseur; Type: TABLE; Schema: madera; Owner: postgres
--

CREATE TABLE madera.fournisseur (
    i_fournisseur_id serial,
    v_raison_soc character varying(45),
    i_adresse_id integer NOT NULL
);


ALTER TABLE madera.fournisseur OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 24598)
-- Name: gammes; Type: TABLE; Schema: madera; Owner: postgres
--

CREATE TABLE madera.gammes (
    i_gammes_id serial,
    v_libelle_gammes character varying(45)
);


ALTER TABLE madera.gammes OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 24608)
-- Name: module; Type: TABLE; Schema: madera; Owner: postgres
--

CREATE TABLE madera.module (
    i_module_id serial,
    i_gammes_id integer NOT NULL,
    i_module_referentiel_id integer NOT NULL,
    v_nom varchar(50),
    v_nature_module character varying(45),
    f_prix_module double precision
);


ALTER TABLE madera.module OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 24682)
-- Name: module_composant; Type: TABLE; Schema: madera; Owner: postgres
--

CREATE TABLE madera.module_composant (
    i_module_id integer NOT NULL,
    i_composant_id integer NOT NULL,
    i_ordre integer NOT NULL
);


ALTER TABLE madera.module_composant OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 24603)
-- Name: module_referentiel; Type: TABLE; Schema: madera; Owner: postgres
--

CREATE TABLE madera.module_referentiel (
    i_module_referentiel_id serial,
    v_caracteristique character varying(45),
    v_unite_usage character varying(45)
);


ALTER TABLE madera.module_referentiel OWNER TO postgres;

-- Un client va créer un projet

CREATE TABLE madera.projet (
    i_projet_id serial,
    i_client_id integer NOT NULL,
    v_nom_projet character varying(50),
    v_ref_projet character varying(45),
    d_date_projet date,
    v_signature_projet bytea,
    i_devis_etat_id integer,
    f_prix_total double precision,
    is_synchro boolean
);


-- Dans produit seront regroupés les produits des clients mais également ceux des modèles
CREATE TABLE madera.produit (
    i_produit_id serial,
    v_produit_nom varchar(50) NOT NULL,
    i_gammes_id integer NOT NULL,
    f_prix_produit double precision,
    b_modele boolean default false
);

-- le type de remplissage et les finitions doivent être modifiable si le client le souhaite
-- Je pense ............
--Quid de la coupe de principe ?

-- Le projet peux contenir plusieurs produits

CREATE TABLE madera.projet_produits (
    i_projet_id integer NOT NULL,
    i_produit_id integer NOT NULL
);

-- Un produit contient des modules avec des modifications apportées par le client
-- Pour chaque module il faudra renseigner la longueur de chaque section (une section dans ce contexte
-- là est le pan mur jusqu'à l'angle ensuite on passe sur une autre section).
-- Exemple : mur droit n'aura qu'une section et donc qu'une longueur
-- Et mur avec angle : aura donc 2 sections avec deux longueurs différentes
CREATE TABLE madera.produit_module (--changement nom table
    i_produit_module_id serial,
    i_produit_id integer NOT NULL, -- Foreign key produit
    i_module_id integer NOT NULL, -- Foreign key module
    v_produit_module_nom varchar(50),
    v_produit_module_angle varchar(30),
    j_section_longueur jsonb,
    f_prix float
);


ALTER TABLE madera.produit_module OWNER TO postgres;


CREATE TABLE madera.projet_utilisateurs (
    i_utilisateur_id integer NOT NULL,
    i_projet_id integer NOT NULL
);


ALTER TABLE madera.projet_utilisateurs OWNER TO postgres;


CREATE TABLE madera.role (
    i_role_id serial,
    v_libelle_role character varying(45)
);


ALTER TABLE madera.role OWNER TO postgres;


CREATE TABLE madera.utilisateur (
    i_utilisateur_id serial,
    v_nom character varying(45),
    v_prenom character varying(45),
    v_date_naissance character varying(45),
    v_mail character varying(45),
    v_tel character varying(45),
    v_login character varying(45),
    v_password character varying(255),
    i_role_id integer NOT NULL,
    v_token varchar(255)
);


ALTER TABLE madera.utilisateur OWNER TO postgres;

CREATE INDEX fk_adresse_idx ON madera.fournisseur USING btree (i_adresse_id);

CREATE INDEX fk_adresse_idx_2 ON madera.client_adresse USING btree (i_adresse_id);

CREATE INDEX fk_client_idx ON madera.projet USING btree (i_client_id);

CREATE INDEX fk_composant_groupe_idx ON madera.composant USING btree (i_composant_groupe_id);

CREATE INDEX fk_composant_idx ON madera.module_composant USING btree (i_composant_id);

CREATE INDEX fk_composant_referentiel_idx ON madera.composant USING btree (i_composant_referentiel_id);

CREATE INDEX fk_fournisseur_idx ON madera.composant_fournisseur USING btree (i_fournisseur_id);


CREATE INDEX fk_gammes_idx ON madera.module USING btree (i_gammes_id);


--
-- TOC entry 2785 (class 1259 OID 24845)
-- Name: fk_module_idx; Type: INDEX; Schema: madera; Owner: postgres
--

CREATE INDEX fk_module_idx ON madera.projet_produits USING btree (i_projet_id, i_produit_id);


--
-- TOC entry 2754 (class 1259 OID 24624)
-- Name: fk_module_referentiel_idx; Type: INDEX; Schema: madera; Owner: postgres
--

CREATE INDEX fk_module_referentiel_idx ON madera.module USING btree (i_module_referentiel_id);

--
-- TOC entry 2784 (class 1259 OID 24813)
-- Name: fk_projet_idx_2; Type: INDEX; Schema: madera; Owner: postgres
--

CREATE INDEX fk_projet_idx_2 ON madera.projet_utilisateurs USING btree (i_projet_id);


--
-- TOC entry 2786 (class 1259 OID 24844)
-- Name: fk_projet_idx_3; Type: INDEX; Schema: madera; Owner: postgres
--

CREATE INDEX fk_projet_idx_3 ON madera.produit_module USING btree (i_produit_module_id);


--
-- TOC entry 2767 (class 1259 OID 24667)
-- Name: fk_role_idx; Type: INDEX; Schema: madera; Owner: postgres
--

CREATE INDEX fk_role_idx ON madera.utilisateur USING btree (i_role_id);



-- Contrainte madera.adresse

ALTER TABLE ONLY madera.adresse
    ADD CONSTRAINT adresse_pkey PRIMARY KEY (i_adresse_id);


-- Contrainte madera.client

ALTER TABLE ONLY madera.client
    ADD CONSTRAINT client_pkey PRIMARY KEY (i_client_id);


-- Contrainte madera.client_adresse

ALTER TABLE ONLY madera.client_adresse
    ADD CONSTRAINT fk_adresse_2 FOREIGN KEY (i_adresse_id) REFERENCES madera.adresse(i_adresse_id);

ALTER TABLE ONLY madera.client_adresse
    ADD CONSTRAINT fk_client_2 FOREIGN KEY (i_client_id) REFERENCES madera.client(i_client_id);

-- Contrainte madera.composant_groupe

ALTER TABLE ONLY madera.composant_groupe
    ADD CONSTRAINT composant_groupe_pkey PRIMARY KEY (i_composant_groupe_id);


-- Contrainte madera.composant_referentiel

ALTER TABLE ONLY madera.composant_referentiel
    ADD CONSTRAINT composant_referentiel_pkey PRIMARY KEY (i_composant_referentiel_id);


-- Contrainte madera.composant

ALTER TABLE ONLY madera.composant
    ADD CONSTRAINT composant_pkey PRIMARY KEY (i_composant_id);

ALTER TABLE ONLY madera.composant
    ADD CONSTRAINT fk_composant_groupe FOREIGN KEY (i_composant_groupe_id) REFERENCES madera.composant_groupe(i_composant_groupe_id);

ALTER TABLE ONLY madera.composant
    ADD CONSTRAINT fk_composant_referentiel FOREIGN KEY (i_composant_referentiel_id) REFERENCES madera.composant_referentiel(i_composant_referentiel_id);


-- Contrainte madera.fournisseur

ALTER TABLE ONLY madera.fournisseur
    ADD CONSTRAINT fournisseur_pkey PRIMARY KEY (i_fournisseur_id);

ALTER TABLE ONLY madera.fournisseur
    ADD CONSTRAINT fk_adresse_2 FOREIGN KEY (i_adresse_id) REFERENCES madera.adresse(i_adresse_id);


-- Contrainte madera.composant_fournisseur

ALTER TABLE ONLY madera.composant_fournisseur
    ADD CONSTRAINT composant_fournisseur_pkey PRIMARY KEY (i_fournisseur_id, i_composant_id);

ALTER TABLE ONLY madera.composant_fournisseur
    ADD CONSTRAINT fk_composant_2 FOREIGN KEY (i_composant_id) REFERENCES madera.composant(i_composant_id);

ALTER TABLE ONLY madera.composant_fournisseur
    ADD CONSTRAINT fk_fournisseur FOREIGN KEY (i_fournisseur_id) REFERENCES madera.fournisseur(i_fournisseur_id);


-- Contrainte madera.devis_etat

ALTER TABLE ONLY madera.devis_etat
    ADD CONSTRAINT devis_etat_pkey PRIMARY KEY (i_devis_etat_id);



-- Contrainte madera.gammes

ALTER TABLE ONLY madera.gammes
    ADD CONSTRAINT gammes_pkey PRIMARY KEY (i_gammes_id);


-- Contrainte madera.module_referentiel

ALTER TABLE ONLY madera.module_referentiel
    ADD CONSTRAINT module_referentiel_pkey PRIMARY KEY (i_module_referentiel_id);


-- Contrainte madera.module

ALTER TABLE ONLY madera.module
    ADD CONSTRAINT module_pkey PRIMARY KEY (i_module_id);

ALTER TABLE ONLY madera.module
    ADD CONSTRAINT fk_gammes FOREIGN KEY (i_gammes_id) REFERENCES madera.gammes(i_gammes_id);

ALTER TABLE ONLY madera.module
    ADD CONSTRAINT fk_module_referentiel FOREIGN KEY (i_module_referentiel_id) REFERENCES madera.module_referentiel(i_module_referentiel_id);


-- Contrainte madera.module_composant

ALTER TABLE ONLY madera.module_composant
    ADD CONSTRAINT fk_composant FOREIGN KEY (i_composant_id) REFERENCES madera.composant(i_composant_id);

ALTER TABLE ONLY madera.module_composant
    ADD CONSTRAINT fk_module FOREIGN KEY (i_module_id) REFERENCES madera.module(i_module_id);


-- Contrainte madera.projet

ALTER TABLE ONLY madera.projet
    ADD CONSTRAINT projet_pkey PRIMARY KEY (i_projet_id);

ALTER TABLE ONLY madera.projet
    ADD CONSTRAINT fk_devis_etat FOREIGN KEY (i_devis_etat_id) REFERENCES madera.devis_etat(i_devis_etat_id);

ALTER TABLE madera.projet
    ADD CONSTRAINT ref_projet_unique UNIQUE (v_ref_projet);

-- Contrainte madera.produit

ALTER TABLE ONLY madera.produit
    ADD CONSTRAINT produit_key PRIMARY KEY (i_produit_id);

ALTER TABLE ONLY madera.produit
    ADD CONSTRAINT produit FOREIGN KEY (i_gammes_id) REFERENCES madera.gammes(i_gammes_id);


-- Contrainte madera.projet_produits

ALTER TABLE ONLY madera.projet_produits
    ADD CONSTRAINT projet_produits_pkey PRIMARY KEY (i_projet_id, i_produit_id);

ALTER TABLE ONLY madera.projet_produits
    ADD CONSTRAINT fk_projet_2 FOREIGN KEY (i_projet_id) REFERENCES madera.projet(i_projet_id);

ALTER TABLE ONLY madera.projet_produits
    ADD CONSTRAINT fk_projet_produits FOREIGN KEY (i_produit_id) REFERENCES madera.produit(i_produit_id);


-- Contrainte produit_modules

ALTER TABLE ONLY madera.produit_module
    ADD CONSTRAINT produit_module_pkey PRIMARY KEY (i_produit_module_id);

ALTER TABLE ONLY madera.produit_module
    ADD CONSTRAINT fk_produit_module FOREIGN KEY (i_produit_id) REFERENCES madera.produit(i_produit_id);

ALTER TABLE ONLY madera.produit_module
    ADD CONSTRAINT fk_module_2 FOREIGN KEY (i_module_id) REFERENCES madera.module(i_module_id);


-- Contrainte madera.role

ALTER TABLE ONLY madera.role
    ADD CONSTRAINT role_pkey PRIMARY KEY (i_role_id);


-- Contrainte madera.utilisateur

ALTER TABLE ONLY madera.utilisateur
    ADD CONSTRAINT utilisateur_pkey PRIMARY KEY (i_utilisateur_id);

ALTER TABLE ONLY madera.utilisateur
    ADD CONSTRAINT fk_role FOREIGN KEY (i_role_id) REFERENCES madera.role(i_role_id);


-- Contrainte madera.projet_utilisateurs

ALTER TABLE ONLY madera.projet_utilisateurs
    ADD CONSTRAINT projet_utilisateurs_pkey PRIMARY KEY (i_utilisateur_id, i_projet_id);

ALTER TABLE ONLY madera.projet_utilisateurs
    ADD CONSTRAINT fk_projet_3 FOREIGN KEY (i_projet_id) REFERENCES madera.projet(i_projet_id);

ALTER TABLE ONLY madera.projet_utilisateurs
    ADD CONSTRAINT fk_utilisateurs FOREIGN KEY (i_utilisateur_id) REFERENCES madera.utilisateur(i_utilisateur_id);

--
-- TOC entry 2746 (class 1259 OID 24597)
-- Name: fk_adresse_idx; Type: INDEX; Schema: madera; Owner: postgres
--
