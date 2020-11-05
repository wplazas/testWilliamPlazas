package controller;

import entities.Documento;
import entities.Recorte;
import java.util.Collection;
import facade.DocumentoFacade;
import controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "documentoController")
@ViewScoped
public class DocumentoController extends AbstractController<Documento> {

    @Inject
    private FormatoController idformatoController;
    @Inject
    private MobilePageController mobilePageController;

    // Flags to indicate if child collections are empty
    private boolean isRecorteCollectionEmpty;

    public DocumentoController() {
        // Inform the Abstract parent controller of the concrete Documento Entity
        super(Documento.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idformatoController.setSelected(null);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsRecorteCollectionEmpty();
    }

    public boolean getIsRecorteCollectionEmpty() {
        return this.isRecorteCollectionEmpty;
    }

    private void setIsRecorteCollectionEmpty() {
        Documento selected = this.getSelected();
        if (selected != null) {
            DocumentoFacade ejbFacade = (DocumentoFacade) this.getFacade();
            this.isRecorteCollectionEmpty = ejbFacade.isRecorteCollectionEmpty(selected);
        } else {
            this.isRecorteCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Recorte entities that are
     * retrieved from Documento and returns the navigation outcome.
     *
     * @return navigation outcome for Recorte page
     */
    public String navigateRecorteCollection() {
        Documento selected = this.getSelected();
        if (selected != null) {
            DocumentoFacade ejbFacade = (DocumentoFacade) this.getFacade();
            Collection<Recorte> selectedRecorteCollection = ejbFacade.findRecorteCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Recorte_items", selectedRecorteCollection);
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/app/recorte/index";
    }

    /**
     * Sets the "selected" attribute of the Formato controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdformato(ActionEvent event) {
        Documento selected = this.getSelected();
        if (selected != null && idformatoController.getSelected() == null) {
            idformatoController.setSelected(selected.getIdformato());
        }
    }

}
