package br

import com.sap.smb.sbo.api.SBOCOMConstants
import com.sap.smb.sbo.api.SBOCOMUtil
import javax.swing.JLabel
import javax.swing.JOptionPane
import javax.swing.JPanel
import javax.swing.JPasswordField


class Main{
    companion object {
        fun main(args : Array<String>){
            main()
        }
    }
}
fun main() {
    try{
//        System.load("/home/satanas/lab/sap-kotlin/lib/sbojni.dll")
//        System.load("/home/andrew/SapB1/lib/sbojni.dll")
        val company = SBOCOMUtil.newCompany()
        company.setServer("")
//        company.setCompanyDB("HOMOLOGAÇÃO 13/12")
        company.setCompanyDB("")
        company.setUserName("")
        company.setPassword(getPassword("usuario"))
        company.setDbServerType(SBOCOMConstants.BoDataServerTypes_dst_HANADB)
        company.setUseTrusted(false)
        company.setLanguage(SBOCOMConstants.BoSuppLangs_ln_Portuguese_Br);
        company.setDbUserName("");
        company.setDbPassword(getPassword(""));
//        company.setAddonIdentifier("...");
        company.setLicenseServer("...");

        val rc = company.connect();
        if (rc == 0) {
            System.out.println("Connected!");
        } else {
            var errMsg = company.getLastError();
            System.out.println(
                "I cannot connect to database server: "
                        + errMsg.getErrorMessage()
                        + " "
                        + errMsg.getErrorCode());
        }

        company.connect()

    }catch (t : Throwable){
        t.printStackTrace()
        val url = ""
    }
}

fun getPassword(s: String): String {
    val panel = JPanel()
    val label = JLabel("$s password:")
    val pass = JPasswordField(10)
    panel.add(label)
    panel.add(pass)
    val options = arrayOf("OK", "Cancel")
    val option = JOptionPane.showOptionDialog(
        null, panel, "The title",
        JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE,
        null, null, options[1]
    )
//    return String(pass.password)
    return ""
}