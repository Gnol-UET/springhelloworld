package org.wso2.msf4j.example.interfaceController;

import org.wso2.msf4j.example.model.DTO.PersonDTO;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Long on 8/22/2016.
 */
public interface IPerson extends Serializable {
    public List<PersonDTO> getListPerson(int quantity);

    public List<PersonDTO> getListPerson();
}
