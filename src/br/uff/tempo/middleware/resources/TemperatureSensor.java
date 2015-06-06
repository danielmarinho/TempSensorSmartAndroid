package br.uff.tempo.middleware.resources;

import android.util.Log;
import br.uff.tempo.middleware.management.ResourceAgent;
import br.uff.tempo.middleware.resources.interfaces.ITemperatureSensor;

public class TemperatureSensor extends ResourceAgent implements ITemperatureSensor {
	
	private static final long serialVersionUID = 1L;
	
	private static final String TAG = "TemperatureSensor";
	private boolean ready = false;
	private float temperature = 0.0f;
	public static final String CV_ISREADY = "isReady";
	public static final String CV_TEMPERATURE = "temperature";
	private String message = "";
	
	public TemperatureSensor(String name, String rans) {
		super(name, "br.uff.tempo.middleware.resources.TemperatureSensor", rans);
	}

	@Override
	@ContextVariable(name = "Está pronto", type = "IsReady")
	public boolean isReady() {
		return ready;
	}

	@Override
	@ContextVariable(name = "Temperatura", type = "Temperature")
	public float temperature() {
		return temperature;
	}

	@Override
	@Service(name = "Definir se está pronto", type = "SetIsReady")
	public void setIsReady(boolean d) {
		Log.i(TAG, this.getName() + " - pronto setado como: " + d);
		ready = d;
		
		notifyStakeholders(CV_ISREADY, temperature);
	}

	@Override
	@Service(name = "Definir temperatura", type = "SetTemperature")
	public void setTemperature(float l) {
		Log.i(TAG, this.getName() + " - setando temperatura para " + l);
		temperature = l;
		
		notifyStakeholders(CV_TEMPERATURE, temperature);
	}

	@Override
	public void notificationHandler(String rai, String method, Object value) {
	}
	
	@Override
	public void showMessage(String text) {
		Log.i(TAG, this.getName() + " - show message: " + text);
		this.message = text;
		notifyStakeholders("showMessage", text);
	}
}
