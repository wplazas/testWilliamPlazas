package entities;

import entities.Documento;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-11-04T22:03:21")
@StaticMetamodel(Recorte.class)
public class Recorte_ { 

    public static volatile SingularAttribute<Recorte, Documento> iddocumento;
    public static volatile SingularAttribute<Recorte, String> ruta;
    public static volatile SingularAttribute<Recorte, Date> fechahoracrea;
    public static volatile SingularAttribute<Recorte, Integer> id;
    public static volatile SingularAttribute<Recorte, Date> fhoramodifica;

}