package DatabaseManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import exceptions.UnsupportedObjectTypeException;
import gerenciadorpasse.*;

@XmlRootElement(name="database")
public class Database {
    private List<User> users = new ArrayList<>();
    private final File file = Paths.get("..", "app", "data", "database.xml").toFile();

    public Database(boolean load) {
        if (load) {
            this.load();
        }
    }

    public Database() {

    }

    @XmlElementWrapper(name="usuarios")
    @XmlElement(name="usuario")
    public List<User> getUsers() {
        return users;
    }
    
    public void insert(Object object) {
        if (object instanceof User) {
            this.users.add((User)object);
        }
        else {
            throw new UnsupportedObjectTypeException("Objeto invalido");
        }

        this.save();
    }

    private <T> void update(T newItem, List<T> data){
        for(int i=0;i<data.size();i++){
            Object item = data.get(i);

            if(item.equals(newItem)){
                data.set(i, newItem);
            }
        }
    }

    public void update(Object object) {
        if (object instanceof User) {
            this.update((User)object, this.users);
        }
        else {
            throw new UnsupportedObjectTypeException("Objeto invalido");
        }

        this.save();
    }

    private void save() {
        try {
            JAXBContext context = JAXBContext.newInstance(Database.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            OutputStream outputStream = new FileOutputStream(this.file);
            marshaller.marshal(this, outputStream);
            outputStream.close();
        } catch(JAXBException | IOException e){
            e.printStackTrace();
        }
    }

    private void load() {
        if (file.exists()) {
            try {
                JAXBContext context = JAXBContext.newInstance(Database.class);
                Unmarshaller unmarshaller = context.createUnmarshaller();
    
                InputStream inputStream = new FileInputStream(this.file);
                Database db = (Database) unmarshaller.unmarshal(inputStream);
                inputStream.close();
    
                this.users = db.getUsers();

            } catch (JAXBException | IOException e) {
                e.printStackTrace();
            }
        }
    } 
}
