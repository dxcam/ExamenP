/*package BusinessLogic;

import java.util.List;
import CCDataAccess.RegistroDAO;
import CCDataAccess.DTO.RegistroDTO;

public class CCRegistroBL {
    private RegistroDAO rDao = new RegistroDAO();

    public CCRegistroBL() {}

    public List<RegistroDTO> getAll() throws Exception {
        List<RegistroDTO> lst = rDao.readAll();
        for (RegistroDTO registroDTO : lst) 
            registroDTO.setUsername(registroDTO.getUsername().toUpperCase());
        return lst;
    }

    public RegistroDTO getBy(int IdRegistro) throws Exception {
        return rDao.readBy(IdRegistro);
    }

    public boolean add(RegistroDTO registroDTO) throws Exception {
        return rDao.create(registroDTO);
    }

    public boolean update(RegistroDTO registroDTO) throws Exception {
        return rDao.update(registroDTO);
    }

    public boolean delete(int IdRegistro) throws Exception {
        return rDao.delete(IdRegistro);
    }
}


*/