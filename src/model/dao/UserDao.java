package model.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import model.User;

//파일에서 list<User> 정보를 읽어오거나 저장하는 기능
public class UserDao {
    private String filename;

    public UserDao(String filename) {
        this.filename = filename;
    }

    //리스트를 받아와 저장
    public void saveUser(List<User> list) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(list);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    //파일로부터 읽어들여 저장
    public List<User> loadUser() {
        File file = new File(filename);

        if (!file.exists()) {
            return new ArrayList<>();
        }

        List<User> list = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            list = (List<User>) in.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }
}
