package org.wso2.msf4j.example.interfaceController;


import org.wso2.msf4j.example.model.DTO.StudentDTO;

import java.util.List;

/**
 * Created by Administrator on 8/19/2016.
 */
public interface IStudent {
    public List<StudentDTO> getAll(int quantity);
}
