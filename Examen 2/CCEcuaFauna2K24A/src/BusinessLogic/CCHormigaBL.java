/*package BusinessLogic;

import java.util.List;

import DataAccess.CCHormigaDAO;
import DataAccess.DTO.CCHormigaDTO;

public class CCHormigaBL {
    private CCHormigaDTO sexo;
    private CCHormigaDAO sDAO = new CCHormigaDAO();

    public CCHormigaBL(){}

    public List<CCHormigaDTO> getAll() throws Exception{
        List<CCHormigaDTO> lst = sDAO.readAll();
        for (CCHormigaDTO XXHormigaDTO : lst) 
            XXHormigaDTO.setTipoHormiga(XXHormigaDTO.getTipoHormiga());
        return lst;
    }
    public CCHormigaDTO getBy(int idSexo) throws Exception{
        sexo = sDAO.readBy(idSexo);
        return sexo;
    }
    public boolean add(CCHormigaDTO XXHormigaDTO) throws Exception{   
        return sDAO.create(XXHormigaDTO);
    }
    public boolean update(CCHormigaDTO XXHormigaDTO) throws Exception{
        return sDAO.update(XXHormigaDTO);
    }
    public boolean delete(int idSexo) throws Exception{
        return sDAO.delete(idSexo);
    }
    public Integer getRowCount() throws Exception{
        return sDAO.getMaxRow();
    }
}
*/