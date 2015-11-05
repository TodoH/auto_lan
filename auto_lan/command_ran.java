package auto_lan;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.Timer;

public class command_ran implements ActionListener {
	private Timer timer;
	private String id;
	private String pass;
	private Pattern pat = Pattern.compile("SENSHUWL");
	private Pattern login_pat = Pattern.compile("logout");

	private Matcher m;
	private Runtime curl;
	private Process curl_p;
	private URL addres;
	private boolean login_flag = false;

	command_ran(String id, char[] pass) {
		this.id = id;
		this.pass = new String(pass);
		timer = new Timer(10000, this);
		timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		try {

			Runtime runtime = Runtime.getRuntime();
			Process p = runtime
					.exec("/System/Library/PrivateFrameworks/Apple80211.framework/Versions/A/Resources/airport -I");
			BufferedReader in = new BufferedReader(new InputStreamReader(
					p.getInputStream()));
			String line;
			String com = new String("curl -d user=" + id + "&password=" + pass
					+ " https://wcgw.senshu-u.ac.jp/cgi-bin/login\n");

			while ((line = in.readLine()) != null) {

				m = pat.matcher(line);
				if (m.find()) {
					if (login_flag == false) {
						try {
							curl = Runtime.getRuntime();
							curl_p = curl.exec(com);
							BufferedReader in2 = new BufferedReader(
									new InputStreamReader(
											curl_p.getInputStream()));
							String line2;
							while ((line2 = in2.readLine()) != null) {
								m = login_pat.matcher(line2);
								if (m.find()) {
									login_flag = true;
									System.out.println("login!!!!");
									runtime.exec("say -v Kyoko せんしゅうだいがくの　むせんらんに　ろぐいん　できました");

								}
							}
						} catch (IOException ex) {
						}
					}
				} else {
					login_flag = false;
				}
			}
		} catch (IOException ex) {
		}
	}
}
