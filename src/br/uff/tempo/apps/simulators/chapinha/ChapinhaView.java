package br.uff.tempo.apps.simulators.chapinha;

import android.os.Bundle;
import br.uff.tempo.R;
import br.uff.tempo.apps.simulators.AbstractPanel;
import br.uff.tempo.apps.simulators.AbstractView;
import br.uff.tempo.middleware.management.interfaces.IResourceAgent;
import br.uff.tempo.middleware.resources.TemperatureSensor;

public class ChapinhaView extends AbstractView {

	@Override
	public void createView(Bundle savedInstanceState) {
		setContentView(R.layout.chapinha);
	}

	@Override
	public IResourceAgent createNewResourceAgent() {
		
		String name = "Chapinha" + getNextID();
		return new TemperatureSensor(name, name);		
	}

	@Override
	public AbstractPanel getPanel() {
		return (AbstractPanel) findViewById(R.id.chapinhaPanel);
	}
}