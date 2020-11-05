package entities;

import entities.Documento;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-11-04T22:03:21")
@StaticMetamodel(Formato.class)
public class Formato_ { 

    public static volatile SingularAttribute<Formato, String> descDocumento;
    public static volatile CollectionAttribute<Formato, Documento> documentoCollection;
    public static volatile SingularAttribute<Formato, Integer> id;
    public static volatile SingularAttribute<Formato, String> nombreDoc;
    public static volatile SingularAttribute<Formato, Date> fhoramodifica;

}