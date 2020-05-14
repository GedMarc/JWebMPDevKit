package com.guicedee.guicedservlets.webservices.implementations;

import com.guicedee.guicedservlets.undertow.services.UndertowDeploymentConfigurator;
import io.undertow.servlet.api.DeploymentInfo;

import static com.guicedee.guicedservlets.webservices.WSContext.*;

public class JaxWSUndertowDeploymentConfigurator
		implements UndertowDeploymentConfigurator
{

	@Override
	public DeploymentInfo configure(DeploymentInfo deploymentInfo)
	{
		deploymentInfo.addServletContextAttribute("jaxws.properties", renderServices(getProviders()));
		return deploymentInfo;
	}
}
