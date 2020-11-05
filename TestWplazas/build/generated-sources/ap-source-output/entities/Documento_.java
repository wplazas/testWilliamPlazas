package entities;

import entities.Formato;
import entities.Recorte;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-11-04T22:03:21")
@StaticMetamodel(Documento.class)
public class Documento_ { 

    public static volatile SingularAttribute<Documento, String> ruta;
    public static volatile SingularAttribute<Documento, Date> fechahoracrea;
    public static volatile SingularAttribute<Documento, Integer> id;
    public static volatile SingularAttribute<Documento, Formato> idformato;
    public static volatile CollectionAttribute<Documento, Recorte> recorteCollection;
    public static volatile SingularAttribute<Documento, Date> fhoramodifica;

}