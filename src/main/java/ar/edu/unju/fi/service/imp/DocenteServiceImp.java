package ar.edu.unju.fi.service.imp;

import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Docente;
import ar.edu.unju.fi.repository.DocenteRepository;
import ar.edu.unju.fi.service.IDocenteService;
import ar.edu.unju.fi.util.ListaDocente;

@Service("DocenteServiceImpList")
public class DocenteServiceImp implements IDocenteService{

    @Autowired
    DocenteRepository docenteDaoImp; 

    private static final Log LOGGER = LogFactory.getLog(DocenteServiceImp.class);

    @Override
    public void saveDocente(Docente docente){
    	docenteDaoImp.save(docente);
    }
	
}
