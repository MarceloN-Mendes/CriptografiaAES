/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author odlan
 */
public class RoundKeys {
    private byte[] senhaOrg;
    private int Rounds;
    public byte[][] RoundKeysAES128 = new byte[11][16];
    public byte[][] RoundKeysAES192 = new byte[13][16];
    public byte[][] RoundKeysAES256 = new byte[15][16];
    private byte[] roundKey;
    
    byte[] RCON = {(byte)0x01, (byte)0x02, (byte)0x04, (byte)0x08, (byte)0x10, (byte)0x20, (byte)0x40, (byte)0x80, (byte)0x1B, (byte)0x36}; 
    
    public void setRounds (int _Rounds){
        this.Rounds = _Rounds;
        calcularSubKeys();
    }
    public int getRound (){return Rounds;}
    public void setSenhaOrg (byte[] _senhaOrg) {senhaOrg = _senhaOrg;}
    
    
    public void calcularSubKeys(){
        
    }
    public void transferirKeys(){
        int W=16;
        if(Rounds == 16){
            for(int i = 1; i <= 10;i++){
                for(int j= 0; j < 16; j++){
                    RoundKeysAES128[i][j] = roundKey[W];
                    W++;
                }
            }
        } else {
            if(Rounds >= 24 && Rounds < 32){
                for(int i = 1; i <= 12; i++){
                    for(int j= 0; j < 16; j++){
                        RoundKeysAES192[i][j] = roundKey[W];
                        W++;
                    }
                }
            } else {
                for(int i = 1; i <= 14;i++){
                    for(int j= 0; j < 16; j++){
                        RoundKeysAES256[i][j] = roundKey[W];
                        W++;
                    }
                }
            }
        }
    }
}
