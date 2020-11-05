package controller;

import entities.Formato;
import entities.Documento;
import java.util.Collection;
import facade.FormatoFacade;
import controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "formatoController")
@ViewScoped
public class FormatoController extends AbstractController<Formato> {

    @Inject
    private MobilePageController mobilePageController;

    // Flags to indicate if child collections are empty
    private boolean isDocumentoCollectionEmpty;

    public FormatoController() {
        // Inform the Abstract parent controller of the concrete Formato Entity
        super(Formato.class);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsDocumentoCollectionEmpty();
    }

    public boolean getIsDocumentoCollectionEmpty() {
        return this.isDocumentoCollectionEmpty;
    }

    private void setIsDocumentoCollectionEmpty() {
        Formato selected = this.getSelected();
        if (selected != null) {
            FormatoFacade ejbFacade = (FormatoFacade) this.getFacade();
            this.isDocumentoCollectionEmpty = ejbFacade.isDocumentoCollectionEmpty(selected);
        } else {
            this.isDocumentoCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Documento entities that
     * are retrieved from Formato and returns the navigation outcome.
     *
     * @return navigation outcome for Documento page
     */
    public String navigateDocumentoCollection() {
        Formato selected = this.getSelected();
        if (selected != null) {
            FormatoFacade ejbFacade = (FormatoFacade) this.getFacade();
            Collection<Documento> selectedDocumentoCollection = ejbFacade.findDocumentoCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Documento_items", selectedDocumentoCollection);
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/app/documento/index";
    }

}
