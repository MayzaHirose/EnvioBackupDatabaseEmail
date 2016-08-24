/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.mhcs.backupmail.main;

import br.com.mhcs.backupmail.databasebackup.DatabaseBackup;
import br.com.mhcs.backupmail.envioemail.EnvioEmail;
import org.apache.commons.mail.EmailException;

/**
 *
 * @author MayzaHirose
 */
public class BackupMail {
    public static void main(String[] args) throws EmailException {
        DatabaseBackup.databaseBackup();
        EnvioEmail.sendEmail();
    }
}
