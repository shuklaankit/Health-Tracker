package com.psquickit.managerImpl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psquickit.dao.UserDAO;
import com.psquickit.dto.UserDTO;
import com.psquickit.manager.CommonManager;
import com.psquickit.manager.IndividualUserManager;
import com.psquickit.pojo.IndividualUserRegisterRequest;
import com.psquickit.pojo.IndividualUserRegisterResponse;
import com.psquickit.util.ServiceUtils;

@Service
public class IndividualUserManagerImpl extends CommonManager implements IndividualUserManager {

	private static Logger logger = Logger.getLogger(IndividualUserManagerImpl.class);
	
	@Autowired
	UserDAO userDAO;
	
	@Override
	public IndividualUserRegisterResponse registerUser(IndividualUserRegisterRequest request) throws Exception {
		logger.info("Reaching in manager");
		UserDTO dto = mapUserRequestToDTO(request.getIndividualUser(), null);
		userDAO.save(dto);
		return ServiceUtils.setResponse(new IndividualUserRegisterResponse(), 
				true, "Register User");
	}
	
	
	
}

