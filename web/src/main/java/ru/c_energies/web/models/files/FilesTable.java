package ru.c_energies.web.models.files;

import ru.c_energies.databases.entity.files.FileRow;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FilesTable {
    private final ResultSet resultSet;
    public FilesTable(ResultSet resultSet){
        this.resultSet = resultSet;
    }
    public List<FileRow> list() throws SQLException {
        List<FileRow> list = new ArrayList<>();
        while(resultSet.next()){
            list.add(new FileRow(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("extension"),
                    resultSet.getLong("size"),
                    resultSet.getInt("create_date"),
                    resultSet.getString("content_type"),
                    resultSet.getInt("appeal_type_id")
            ));
        }
        return list;
    }
}
