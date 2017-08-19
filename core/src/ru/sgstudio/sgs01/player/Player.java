package ru.sgstudio.sgs01.player;

public class Player {
	private static int zPlayer, yPlayer, xPlayer;
	
	public int getZPlayer(){ return zPlayer; }
	public int getYPlayer(){ return yPlayer; }
	public int getXPlayer(){ return xPlayer; }
	
	public void setZPlayer(int zPlayer){ Player.zPlayer = zPlayer; }
	public void setYPlayer(int yPlayer){ Player.yPlayer = yPlayer; }
	public void setXPlayer(int xPlayer){ Player.xPlayer = xPlayer; }
}
