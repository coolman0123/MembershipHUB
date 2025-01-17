package model.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import model.User;

public class UserDao {
    private String filename;

    public UserDao(String filename) {
        this.filename = filename;
    }

    // 리스트를 받아와 저장
    public void saveUser(List<User> list) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(list);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // 파일로부터 읽어들여 저장
    public List<User> loadUsers() {
        File file = new File(filename);

        // 파일이 존재하지 않거나 비어 있으면 빈 리스트 반환
        if (!file.exists() || file.length() == 0) {
            return new ArrayList<>();
        }

        List<User> list = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            // 파일에 객체가 있으면 읽어오기
            list = (List<User>) in.readObject();
        } catch (java.io.EOFException ex) {
            // EOFException 발생 시 빈 리스트 반환
            return new ArrayList<>();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }
}
