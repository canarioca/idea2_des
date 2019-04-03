package com.sorin.idea.notificacion;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		NotificacionMaterial obj = new NotificacionMaterial();
		//obj.notificaMaterialGenerador("Adapta VB564", "eerr", "Sorin Group", "4", "DDDRV", "DF-4", "DF-4", "DF-4", "1", "1", "idea-bcn", "gas128");
		obj.notificaMaterialElectrodo("VOLTA","ref","Vulcanizados er bombilla","bipolar", 
				"Activa", "DF-4", "biboina","moeloo","Hospital del mar","111,,1,1m1");
	}

}
