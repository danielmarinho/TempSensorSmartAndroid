package br.uff.tempo.middleware.resources.stubs;

import java.util.ArrayList;
import java.util.List;

import br.uff.tempo.middleware.comm.current.api.Tuple;
import br.uff.tempo.middleware.management.stubs.ResourceAgentStub;
import br.uff.tempo.middleware.resources.TemperatureSensor;
import br.uff.tempo.middleware.resources.interfaces.ITemperatureSensor;

public class TemperatureSensorStub extends ResourceAgentStub implements ITemperatureSensor {
	
	private static final long serialVersionUID = 1L;

	public TemperatureSensorStub(String rai) {
		super(rai);
	}

	@Override
	@ContextVariable(name = "Está pronto", type = "IsReady")
	public boolean isReady() {
		List<Tuple<String, Object>> params = new ArrayList<Tuple<String, Object>>();
		return (Boolean) makeCall(TemperatureSensor.CV_ISREADY, params, Boolean.class);
	}

	@Override
	@ContextVariable(name = "Temperatura", type = "Temperature")
	public float temperature() {
		List<Tuple<String, Object>> params = new ArrayList<Tuple<String, Object>>();
		return (Float) makeCall(TemperatureSensor.CV_TEMPERATURE, params, float.class);
	}

	@Override
	@Service(name = "Definir se está pronto", type = "SetIsReady")
	public void setIsReady(boolean d) {
		List<Tuple<String, Object>> params = new ArrayList<Tuple<String, Object>>();
		params.add(new Tuple<String, Object>(Boolean.class.getName(), d));
		makeCall("setReady", params, void.class);
	}

	@Override
	@Service(name = "Definir temperatura", type = "SetTemperature")
	public void setTemperature(float l) {
		List<Tuple<String, Object>> params = new ArrayList<Tuple<String, Object>>();
		params.add(new Tuple<String, Object>(Float.class.getName(), l));
		makeCall("setTemperature", params, void.class);
	}
	
	@Override
	public void showMessage(String text) {

		List<Tuple<String, Object>> params = new ArrayList<Tuple<String, Object>>();
		params.add(new Tuple<String, Object>(String.class.getName(), text));

		makeCall("showMessage", params, void.class);
	}

}
