package br.uff.tempo.middleware.resources.interfaces;

import br.uff.tempo.middleware.management.interfaces.IResourceAgent;

public interface ITemperatureSensor extends IResourceAgent {

	@ContextVariable(name = "Está pronta", type = "IsReady")
	public boolean isReady();

	@ContextVariable(name = "Temperatura", type = "Temperature")
	public float temperature();

	@Service(name = "Definir se está pronto", type = "SetIsReady")
	public void setIsReady(boolean d);

	@Service(name = "Definir temperatura", type = "SetTemperature")
	public void setTemperature(float l);
	
	/**
	 * Shows a message in the TV screen
	 * 
	 * @param text
	 *            The message that will be showed in the screen
	 */
	public void showMessage(String text);
}