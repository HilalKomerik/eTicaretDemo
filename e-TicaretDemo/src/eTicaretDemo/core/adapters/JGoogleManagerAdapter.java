package eTicaretDemo.core.adapters;

import eTicaretDemo.jGoogle.JGoogleManager;

public class JGoogleManagerAdapter implements ExternalValidationService{

	@Override
	public void signInWithExternal() {
		JGoogleManager manager = new JGoogleManager();
		manager.signInWithGoogle();
	}

}
