/*
 * This file is generated by jOOQ.
 */
package com.madera.jooq;


import com.madera.jooq.tables.Adresse;
import com.madera.jooq.tables.Client;
import com.madera.jooq.tables.ClientAdresse;
import com.madera.jooq.tables.Composant;
import com.madera.jooq.tables.ComposantFournisseur;
import com.madera.jooq.tables.ComposantGroupe;
import com.madera.jooq.tables.ComposantReferentiel;
import com.madera.jooq.tables.DevisEtat;
import com.madera.jooq.tables.Fournisseur;
import com.madera.jooq.tables.Gammes;
import com.madera.jooq.tables.Module;
import com.madera.jooq.tables.ModuleComposant;
import com.madera.jooq.tables.ModuleReferentiel;
import com.madera.jooq.tables.Projet;
import com.madera.jooq.tables.ProjetModule;
import com.madera.jooq.tables.ProjetUtilisateurs;
import com.madera.jooq.tables.Role;
import com.madera.jooq.tables.Utilisateur;
import com.madera.jooq.tables.records.AdresseRecord;
import com.madera.jooq.tables.records.ClientAdresseRecord;
import com.madera.jooq.tables.records.ClientRecord;
import com.madera.jooq.tables.records.ComposantFournisseurRecord;
import com.madera.jooq.tables.records.ComposantGroupeRecord;
import com.madera.jooq.tables.records.ComposantRecord;
import com.madera.jooq.tables.records.ComposantReferentielRecord;
import com.madera.jooq.tables.records.DevisEtatRecord;
import com.madera.jooq.tables.records.FournisseurRecord;
import com.madera.jooq.tables.records.GammesRecord;
import com.madera.jooq.tables.records.ModuleComposantRecord;
import com.madera.jooq.tables.records.ModuleRecord;
import com.madera.jooq.tables.records.ModuleReferentielRecord;
import com.madera.jooq.tables.records.ProjetModuleRecord;
import com.madera.jooq.tables.records.ProjetRecord;
import com.madera.jooq.tables.records.ProjetUtilisateursRecord;
import com.madera.jooq.tables.records.RoleRecord;
import com.madera.jooq.tables.records.UtilisateurRecord;

import javax.annotation.processing.Generated;

import org.jooq.ForeignKey;
import org.jooq.UniqueKey;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables of 
 * the <code>madera</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.3"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------


    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<AdresseRecord> ADRESSE_PKEY = UniqueKeys0.ADRESSE_PKEY;
    public static final UniqueKey<ClientRecord> CLIENT_PKEY = UniqueKeys0.CLIENT_PKEY;
    public static final UniqueKey<ComposantRecord> COMPOSANT_PKEY = UniqueKeys0.COMPOSANT_PKEY;
    public static final UniqueKey<ComposantFournisseurRecord> COMPOSANT_FOURNISSEUR_PKEY = UniqueKeys0.COMPOSANT_FOURNISSEUR_PKEY;
    public static final UniqueKey<ComposantGroupeRecord> COMPOSANT_GROUPE_PKEY = UniqueKeys0.COMPOSANT_GROUPE_PKEY;
    public static final UniqueKey<ComposantReferentielRecord> COMPOSANT_REFERENTIEL_PKEY = UniqueKeys0.COMPOSANT_REFERENTIEL_PKEY;
    public static final UniqueKey<DevisEtatRecord> DEVIS_ETAT_PKEY = UniqueKeys0.DEVIS_ETAT_PKEY;
    public static final UniqueKey<FournisseurRecord> FOURNISSEUR_PKEY = UniqueKeys0.FOURNISSEUR_PKEY;
    public static final UniqueKey<GammesRecord> GAMMES_PKEY = UniqueKeys0.GAMMES_PKEY;
    public static final UniqueKey<ModuleRecord> MODULE_PKEY = UniqueKeys0.MODULE_PKEY;
    public static final UniqueKey<ModuleReferentielRecord> MODULE_REFERENTIEL_PKEY = UniqueKeys0.MODULE_REFERENTIEL_PKEY;
    public static final UniqueKey<ProjetRecord> PROJET_PKEY = UniqueKeys0.PROJET_PKEY;
    public static final UniqueKey<ProjetModuleRecord> PROJET_MODULE_PKEY = UniqueKeys0.PROJET_MODULE_PKEY;
    public static final UniqueKey<RoleRecord> ROLE_PKEY = UniqueKeys0.ROLE_PKEY;
    public static final UniqueKey<UtilisateurRecord> UTILISATEUR_PKEY = UniqueKeys0.UTILISATEUR_PKEY;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<ClientAdresseRecord, ClientRecord> CLIENT_ADRESSE__FK_CLIENT_2 = ForeignKeys0.CLIENT_ADRESSE__FK_CLIENT_2;
    public static final ForeignKey<ClientAdresseRecord, AdresseRecord> CLIENT_ADRESSE__FK_ADRESSE_2 = ForeignKeys0.CLIENT_ADRESSE__FK_ADRESSE_2;
    public static final ForeignKey<ComposantRecord, ComposantGroupeRecord> COMPOSANT__FK_COMPOSANT_GROUPE = ForeignKeys0.COMPOSANT__FK_COMPOSANT_GROUPE;
    public static final ForeignKey<ComposantRecord, ComposantReferentielRecord> COMPOSANT__FK_COMPOSANT_REFERENTIEL = ForeignKeys0.COMPOSANT__FK_COMPOSANT_REFERENTIEL;
    public static final ForeignKey<ComposantFournisseurRecord, ComposantRecord> COMPOSANT_FOURNISSEUR__FK_COMPOSANT_2 = ForeignKeys0.COMPOSANT_FOURNISSEUR__FK_COMPOSANT_2;
    public static final ForeignKey<ComposantFournisseurRecord, FournisseurRecord> COMPOSANT_FOURNISSEUR__FK_FOURNISSEUR = ForeignKeys0.COMPOSANT_FOURNISSEUR__FK_FOURNISSEUR;
    public static final ForeignKey<FournisseurRecord, AdresseRecord> FOURNISSEUR__FK_ADRESSE_2 = ForeignKeys0.FOURNISSEUR__FK_ADRESSE_2;
    public static final ForeignKey<ModuleRecord, GammesRecord> MODULE__FK_GAMMES = ForeignKeys0.MODULE__FK_GAMMES;
    public static final ForeignKey<ModuleRecord, ModuleReferentielRecord> MODULE__FK_MODULE_REFERENTIEL = ForeignKeys0.MODULE__FK_MODULE_REFERENTIEL;
    public static final ForeignKey<ModuleComposantRecord, ModuleRecord> MODULE_COMPOSANT__FK_MODULE = ForeignKeys0.MODULE_COMPOSANT__FK_MODULE;
    public static final ForeignKey<ModuleComposantRecord, ComposantRecord> MODULE_COMPOSANT__FK_COMPOSANT = ForeignKeys0.MODULE_COMPOSANT__FK_COMPOSANT;
    public static final ForeignKey<ProjetRecord, ClientRecord> PROJET__FK_CLIENT = ForeignKeys0.PROJET__FK_CLIENT;
    public static final ForeignKey<ProjetRecord, DevisEtatRecord> PROJET__FK_DEVIS_ETAT = ForeignKeys0.PROJET__FK_DEVIS_ETAT;
    public static final ForeignKey<ProjetModuleRecord, ProjetRecord> PROJET_MODULE__FK_PROJET_2 = ForeignKeys0.PROJET_MODULE__FK_PROJET_2;
    public static final ForeignKey<ProjetModuleRecord, ModuleRecord> PROJET_MODULE__FK_MODULE_2 = ForeignKeys0.PROJET_MODULE__FK_MODULE_2;
    public static final ForeignKey<ProjetUtilisateursRecord, UtilisateurRecord> PROJET_UTILISATEURS__FK_UTILISATEURS = ForeignKeys0.PROJET_UTILISATEURS__FK_UTILISATEURS;
    public static final ForeignKey<ProjetUtilisateursRecord, ProjetRecord> PROJET_UTILISATEURS__FK_PROJET_3 = ForeignKeys0.PROJET_UTILISATEURS__FK_PROJET_3;
    public static final ForeignKey<UtilisateurRecord, RoleRecord> UTILISATEUR__FK_ROLE = ForeignKeys0.UTILISATEUR__FK_ROLE;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class UniqueKeys0 {
        public static final UniqueKey<AdresseRecord> ADRESSE_PKEY = Internal.createUniqueKey(Adresse.ADRESSE, "adresse_pkey", Adresse.ADRESSE.I_ADRESSE_ID);
        public static final UniqueKey<ClientRecord> CLIENT_PKEY = Internal.createUniqueKey(Client.CLIENT, "client_pkey", Client.CLIENT.I_CLIENT_ID);
        public static final UniqueKey<ComposantRecord> COMPOSANT_PKEY = Internal.createUniqueKey(Composant.COMPOSANT, "composant_pkey", Composant.COMPOSANT.I_COMPOSANT_ID);
        public static final UniqueKey<ComposantFournisseurRecord> COMPOSANT_FOURNISSEUR_PKEY = Internal.createUniqueKey(ComposantFournisseur.COMPOSANT_FOURNISSEUR, "composant_fournisseur_pkey", ComposantFournisseur.COMPOSANT_FOURNISSEUR.I_FOURNISSEUR_ID, ComposantFournisseur.COMPOSANT_FOURNISSEUR.I_COMPOSANT_ID);
        public static final UniqueKey<ComposantGroupeRecord> COMPOSANT_GROUPE_PKEY = Internal.createUniqueKey(ComposantGroupe.COMPOSANT_GROUPE, "composant_groupe_pkey", ComposantGroupe.COMPOSANT_GROUPE.I_COMPOSANT_GROUPE_ID);
        public static final UniqueKey<ComposantReferentielRecord> COMPOSANT_REFERENTIEL_PKEY = Internal.createUniqueKey(ComposantReferentiel.COMPOSANT_REFERENTIEL, "composant_referentiel_pkey", ComposantReferentiel.COMPOSANT_REFERENTIEL.I_COMPOSANT_REFERENTIEL_ID);
        public static final UniqueKey<DevisEtatRecord> DEVIS_ETAT_PKEY = Internal.createUniqueKey(DevisEtat.DEVIS_ETAT, "devis_etat_pkey", DevisEtat.DEVIS_ETAT.I_DEVIS_ETAT_ID);
        public static final UniqueKey<FournisseurRecord> FOURNISSEUR_PKEY = Internal.createUniqueKey(Fournisseur.FOURNISSEUR, "fournisseur_pkey", Fournisseur.FOURNISSEUR.I_FOURNISSEUR_ID);
        public static final UniqueKey<GammesRecord> GAMMES_PKEY = Internal.createUniqueKey(Gammes.GAMMES, "gammes_pkey", Gammes.GAMMES.I_GAMMES_ID);
        public static final UniqueKey<ModuleRecord> MODULE_PKEY = Internal.createUniqueKey(Module.MODULE, "module_pkey", Module.MODULE.I_MODULE_ID);
        public static final UniqueKey<ModuleReferentielRecord> MODULE_REFERENTIEL_PKEY = Internal.createUniqueKey(ModuleReferentiel.MODULE_REFERENTIEL, "module_referentiel_pkey", ModuleReferentiel.MODULE_REFERENTIEL.I_MODULE_REFERENTIEL_ID);
        public static final UniqueKey<ProjetRecord> PROJET_PKEY = Internal.createUniqueKey(Projet.PROJET, "projet_pkey", Projet.PROJET.I_PROJET_ID);
        public static final UniqueKey<ProjetModuleRecord> PROJET_MODULE_PKEY = Internal.createUniqueKey(ProjetModule.PROJET_MODULE, "projet_module_pkey", ProjetModule.PROJET_MODULE.I_PROJET_MODULE_ID);
        public static final UniqueKey<RoleRecord> ROLE_PKEY = Internal.createUniqueKey(Role.ROLE, "role_pkey", Role.ROLE.I_ROLE_ID);
        public static final UniqueKey<UtilisateurRecord> UTILISATEUR_PKEY = Internal.createUniqueKey(Utilisateur.UTILISATEUR, "utilisateur_pkey", Utilisateur.UTILISATEUR.I_UTILISATEUR_ID);
    }

    private static class ForeignKeys0 {
        public static final ForeignKey<ClientAdresseRecord, ClientRecord> CLIENT_ADRESSE__FK_CLIENT_2 = Internal.createForeignKey(com.madera.jooq.Keys.CLIENT_PKEY, ClientAdresse.CLIENT_ADRESSE, "client_adresse__fk_client_2", ClientAdresse.CLIENT_ADRESSE.I_CLIENT_ID);
        public static final ForeignKey<ClientAdresseRecord, AdresseRecord> CLIENT_ADRESSE__FK_ADRESSE_2 = Internal.createForeignKey(com.madera.jooq.Keys.ADRESSE_PKEY, ClientAdresse.CLIENT_ADRESSE, "client_adresse__fk_adresse_2", ClientAdresse.CLIENT_ADRESSE.I_ADRESSE_ID);
        public static final ForeignKey<ComposantRecord, ComposantGroupeRecord> COMPOSANT__FK_COMPOSANT_GROUPE = Internal.createForeignKey(com.madera.jooq.Keys.COMPOSANT_GROUPE_PKEY, Composant.COMPOSANT, "composant__fk_composant_groupe", Composant.COMPOSANT.I_COMPOSANT_GROUPE_ID);
        public static final ForeignKey<ComposantRecord, ComposantReferentielRecord> COMPOSANT__FK_COMPOSANT_REFERENTIEL = Internal.createForeignKey(com.madera.jooq.Keys.COMPOSANT_REFERENTIEL_PKEY, Composant.COMPOSANT, "composant__fk_composant_referentiel", Composant.COMPOSANT.I_COMPOSANT_REFERENTIEL_ID);
        public static final ForeignKey<ComposantFournisseurRecord, ComposantRecord> COMPOSANT_FOURNISSEUR__FK_COMPOSANT_2 = Internal.createForeignKey(com.madera.jooq.Keys.COMPOSANT_PKEY, ComposantFournisseur.COMPOSANT_FOURNISSEUR, "composant_fournisseur__fk_composant_2", ComposantFournisseur.COMPOSANT_FOURNISSEUR.I_COMPOSANT_ID);
        public static final ForeignKey<ComposantFournisseurRecord, FournisseurRecord> COMPOSANT_FOURNISSEUR__FK_FOURNISSEUR = Internal.createForeignKey(com.madera.jooq.Keys.FOURNISSEUR_PKEY, ComposantFournisseur.COMPOSANT_FOURNISSEUR, "composant_fournisseur__fk_fournisseur", ComposantFournisseur.COMPOSANT_FOURNISSEUR.I_FOURNISSEUR_ID);
        public static final ForeignKey<FournisseurRecord, AdresseRecord> FOURNISSEUR__FK_ADRESSE_2 = Internal.createForeignKey(com.madera.jooq.Keys.ADRESSE_PKEY, Fournisseur.FOURNISSEUR, "fournisseur__fk_adresse_2", Fournisseur.FOURNISSEUR.I_ADRESSE_ID);
        public static final ForeignKey<ModuleRecord, GammesRecord> MODULE__FK_GAMMES = Internal.createForeignKey(com.madera.jooq.Keys.GAMMES_PKEY, Module.MODULE, "module__fk_gammes", Module.MODULE.I_GAMMES_ID);
        public static final ForeignKey<ModuleRecord, ModuleReferentielRecord> MODULE__FK_MODULE_REFERENTIEL = Internal.createForeignKey(com.madera.jooq.Keys.MODULE_REFERENTIEL_PKEY, Module.MODULE, "module__fk_module_referentiel", Module.MODULE.I_MODULE_REFERENTIEL_ID);
        public static final ForeignKey<ModuleComposantRecord, ModuleRecord> MODULE_COMPOSANT__FK_MODULE = Internal.createForeignKey(com.madera.jooq.Keys.MODULE_PKEY, ModuleComposant.MODULE_COMPOSANT, "module_composant__fk_module", ModuleComposant.MODULE_COMPOSANT.I_MODULE_ID);
        public static final ForeignKey<ModuleComposantRecord, ComposantRecord> MODULE_COMPOSANT__FK_COMPOSANT = Internal.createForeignKey(com.madera.jooq.Keys.COMPOSANT_PKEY, ModuleComposant.MODULE_COMPOSANT, "module_composant__fk_composant", ModuleComposant.MODULE_COMPOSANT.I_COMPOSANT_ID);
        public static final ForeignKey<ProjetRecord, ClientRecord> PROJET__FK_CLIENT = Internal.createForeignKey(com.madera.jooq.Keys.CLIENT_PKEY, Projet.PROJET, "projet__fk_client", Projet.PROJET.I_CLIENT_ID);
        public static final ForeignKey<ProjetRecord, DevisEtatRecord> PROJET__FK_DEVIS_ETAT = Internal.createForeignKey(com.madera.jooq.Keys.DEVIS_ETAT_PKEY, Projet.PROJET, "projet__fk_devis_etat", Projet.PROJET.I_DEVIS_ETAT_ID);
        public static final ForeignKey<ProjetModuleRecord, ProjetRecord> PROJET_MODULE__FK_PROJET_2 = Internal.createForeignKey(com.madera.jooq.Keys.PROJET_PKEY, ProjetModule.PROJET_MODULE, "projet_module__fk_projet_2", ProjetModule.PROJET_MODULE.I_PROJET_ID);
        public static final ForeignKey<ProjetModuleRecord, ModuleRecord> PROJET_MODULE__FK_MODULE_2 = Internal.createForeignKey(com.madera.jooq.Keys.MODULE_PKEY, ProjetModule.PROJET_MODULE, "projet_module__fk_module_2", ProjetModule.PROJET_MODULE.I_MODULE_ID);
        public static final ForeignKey<ProjetUtilisateursRecord, UtilisateurRecord> PROJET_UTILISATEURS__FK_UTILISATEURS = Internal.createForeignKey(com.madera.jooq.Keys.UTILISATEUR_PKEY, ProjetUtilisateurs.PROJET_UTILISATEURS, "projet_utilisateurs__fk_utilisateurs", ProjetUtilisateurs.PROJET_UTILISATEURS.I_UTILISATEUR_ID);
        public static final ForeignKey<ProjetUtilisateursRecord, ProjetRecord> PROJET_UTILISATEURS__FK_PROJET_3 = Internal.createForeignKey(com.madera.jooq.Keys.PROJET_PKEY, ProjetUtilisateurs.PROJET_UTILISATEURS, "projet_utilisateurs__fk_projet_3", ProjetUtilisateurs.PROJET_UTILISATEURS.I_PROJET_ID);
        public static final ForeignKey<UtilisateurRecord, RoleRecord> UTILISATEUR__FK_ROLE = Internal.createForeignKey(com.madera.jooq.Keys.ROLE_PKEY, Utilisateur.UTILISATEUR, "utilisateur__fk_role", Utilisateur.UTILISATEUR.I_ROLE_ID);
    }
}
