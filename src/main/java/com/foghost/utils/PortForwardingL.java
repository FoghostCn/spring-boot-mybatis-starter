package com.foghost.utils;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * this is used for ssh -L
 */
public class PortForwardingL {

	private static final Logger logger = LoggerFactory.getLogger(PortForwardingL.class);

	private static final String host = "";
	private static final int port = 22;
	private static final String user = "";
	private static final String pwd = "";
	private static final int rport = 3306;
	private static final String rhost ="";
	private static final int lport = 2121;

	public static void run() {
		try {
			JSch jsch = new JSch();
			Session session = jsch.getSession(user, host, port);
			session.setConfig("StrictHostKeyChecking", "no");
			session.setUserInfo(new UserInfo() {
				@Override
				public String getPassphrase() {
					return null;
				}

				@Override
				public String getPassword() {
					return pwd;
				}

				@Override
				public boolean promptPassword(String message) {
					return true;
				}

				@Override
				public boolean promptPassphrase(String message) {
					return true;
				}

				@Override
				public boolean promptYesNo(String message) {
					return false;
				}

				@Override
				public void showMessage(String message) {
					logger.debug(message);
				}
			});
			session.connect();
			session.setPortForwardingL(lport, rhost, rport);
			logger.debug("localhost:" + lport + " -> " + rhost + ":" + rport);
		} catch (Exception e) {
			logger.error("fowardingR failed", e);
		}
	}
}
