package com.madera.api.repository;

import com.madera.api.models.Module;
import com.madera.api.models.*;
import com.madera.api.utils.Helper;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.madera.jooq.Tables.*;

/**
 * Repository Réferentiel
 *
 * @author LADOUCE Fabien, CHEVALLIER Romain, HELIOT David
 * @version 1.0-RELEASE
 */
@Repository
public class ReferentielRepository {

    @Autowired
    DSLContext context;

    /**
     *
     * @return la liste des composants
     */
    public List<Composant> getAllComposant() {
        return context.select(COMPOSANT.fields()).select(COMPOSANT_REFERENTIEL.fields())
                .select(COMPOSANT_GROUPE.fields()).from(COMPOSANT).join(COMPOSANT_REFERENTIEL)
                .on(COMPOSANT.I_COMPOSANT_REFERENTIEL_ID.eq(COMPOSANT.I_COMPOSANT_REFERENTIEL_ID))
                .join(COMPOSANT_GROUPE).on(COMPOSANT_GROUPE.I_COMPOSANT_GROUPE_ID.eq(COMPOSANT.I_COMPOSANT_GROUPE_ID))
                .where(COMPOSANT.I_COMPOSANT_REFERENTIEL_ID.eq(COMPOSANT_REFERENTIEL.I_COMPOSANT_REFERENTIEL_ID))
                .fetch(Helper::recordToComposant);
    }

    /**
     *
     * @return la liste des composantGroupe
     */
    public List<ComposantGroupe> getAllComposantGroupe() {
        return context.select(COMPOSANT_GROUPE.fields()).from(COMPOSANT_GROUPE).fetch(Helper::recordToComposantGroupe);
    }

    /**
     *
     * @return la liste des gammes
     */
    public List<Gamme> getAllGammes() {
        return context.select(GAMMES.fields()).from(GAMMES).fetch(Helper::recordToGamme);
    }

    /**
     *
     * @return la liste des modules
     */
    public List<Module> getAllModules() {
        return context.select(MODULE.fields()).select(MODULE_REFERENTIEL.fields()).from(MODULE).join(MODULE_REFERENTIEL)
                .on(MODULE_REFERENTIEL.I_MODULE_REFERENTIEL_ID.eq(MODULE.I_MODULE_REFERENTIEL_ID))
                .fetch(Helper::recordToModule);
    }

    /**
     *
     * @return la liste des moduleComposant
     */
    public List<ModuleComposant> getAllModuleComposant() {
        return context.select(MODULE_COMPOSANT.fields()).from(MODULE_COMPOSANT).fetch(Helper::recordToModuleComposant);
    }

    /**
     *
     * @return la liste des devisEtat
     */
    public List<DevisEtat> getAllDevisEtat() {
        return context.select(DEVIS_ETAT.fields()).from(DEVIS_ETAT).fetch(Helper::recordToDevisEtat);
    }
}
