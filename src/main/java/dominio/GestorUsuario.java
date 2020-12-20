package dominio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import persistencia.AgenteBD;
import presentacion.IU_PersonalSanitario;
import presentacion.IU_Usuario;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class GestorUsuario {

	private List<Vivienda> listaVivienda = new ArrayList<>();
	private List<Ayuntamiento> listaAyuntamiento = new ArrayList<>();

	public void rellenarCombos() {
		IU_Usuario.getcBTipo().setModel(new DefaultComboBoxModel(new String[]{"", "Vivienda Particular", "Residencia Comunitaria"}));
		IU_Usuario.getcBRol().setModel(new DefaultComboBoxModel(new String[]{"", "Personal sanitario", "Ciudadano"}));
	}
	
	public ActionListener btnSUser(JFrame window) {

		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				switch (IU_Usuario.getcBRol().getSelectedItem().toString().toLowerCase()) {
				case "personal sanitario":
					Sanitario s = new Sanitario();

					s.setDni(IU_Usuario.getTxtDni().getText());
					s.setNombre(IU_Usuario.getTxtNombre().getText());
					s.setRol(IU_Usuario.getcBRol().getSelectedItem().toString());
					s.setNSanitario(IU_Usuario.getTxtNSanitario().getText());
					if (checkTokens(s)) {
						if (crearUsuario(s) != null) {
							if (GestorPersonalSanitario.crearSanitario(s) != null) {
								JOptionPane.showMessageDialog(null, "Usuario Personal Sanitario creado correctamente", "HECHO!", JOptionPane.INFORMATION_MESSAGE);
								limpiarCampos(0);
							} else {
								JOptionPane.showMessageDialog(null, "Error al crear el Personal Sanitario"
										+ s.getNombre() + " con dni " + s.getDni(),"ERROR!", JOptionPane.ERROR_MESSAGE);
							}
						} else {
							JOptionPane.showMessageDialog(null, "Usuario con dni \"" + s.getDni() + "\" ya existe ",
									"ERROR!", JOptionPane.ERROR_MESSAGE);
						}

					} else {
						JOptionPane.showMessageDialog(null, "Hay algún campo vacío.", "ERROR!",
								JOptionPane.ERROR_MESSAGE);
					}
					break;
				case "ciudadano":

					Ciudadano c = new Ciudadano();

					c.setDni(IU_Usuario.getTxtDni().getText());
					c.setEmail(IU_Usuario.getTxtEmail().getText());
					c.setNombre(IU_Usuario.getTxtNombre().getText());
					c.setRol(IU_Usuario.getcBRol().getSelectedItem().toString());
					c.setNTarjetaSanitaria(IU_Usuario.getTxtNTarjeta().getText());
					if (checkTokens(c)) {
						if (crearUsuario(c) != null) {
							if (GestorCiudadano.crearCiudadano(c) != null) {
								JOptionPane.showMessageDialog(null, "Usuario Ciudadano creado correctamente", "HECHO!", JOptionPane.INFORMATION_MESSAGE);
								limpiarCampos(0);
							} else {
								JOptionPane.showMessageDialog(null,
										"Error al crear el ciudadano" + c.getNombre() + " con dni " + c.getDni(),
										"ERROR!", JOptionPane.ERROR_MESSAGE);
							}
						} else {
							JOptionPane.showMessageDialog(null, "Usuario con dni \"" + c.getDni() + "\" ya existe.",
									"ERROR!", JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(null, "Hay algún campo vacío.", "ERROR!",
								JOptionPane.ERROR_MESSAGE);
					}

					break;

				}
			}

		};
	}

	public ItemListener selectTypeUser() {
		return new ItemListener() {
			public void itemStateChanged(ItemEvent e) {

				switch (IU_Usuario.getcBRol().getSelectedItem().toString().toLowerCase()) {
				case "personal sanitario":
					disableTokens(0);
					IU_Usuario.getLblNSanitario().setVisible(true);
					IU_Usuario.getTxtNSanitario().setVisible(true);
					break;
				case "ciudadano":
					disableTokens(0);
					IU_Usuario.getLblNTarjeta().setVisible(true);
					IU_Usuario.getTxtNTarjeta().setVisible(true);
					IU_Usuario.getLblEmail().setVisible(true);
					IU_Usuario.getTxtEmail().setVisible(true);
					IU_Usuario.getBtnVivienda().setVisible(true);
					break;
				default:
					disableTokens(1);
					break;
				}

			}
		};
	}

	public void disableTokens(int a) {
		if (a == 0) {
			IU_Usuario.getBtnRegistro().setEnabled(true);
		} else {
			IU_Usuario.getBtnRegistro().setEnabled(false);
		}
		IU_Usuario.getLblNSanitario().setVisible(false);
		IU_Usuario.getTxtNSanitario().setVisible(false);
		IU_Usuario.getLblEmail().setVisible(false);
		IU_Usuario.getTxtEmail().setVisible(false);
		IU_Usuario.getLblNTarjeta().setVisible(false);
		IU_Usuario.getTxtNTarjeta().setVisible(false);
		IU_Usuario.getBtnVivienda().setVisible(false);

	}

	private Usuario crearUsuario(Usuario u) {
		Usuario aux = null;
		Connection CONNECTION = AgenteBD.dbConnector();

		if (this.buscarUsuario(u) == null) {

			PreparedStatement ps;
			try {
				ps = CONNECTION.prepareStatement("INSERT INTO Usuario (dni, nombre, rol) VALUES (?, ?, ?);");

				ps.setString(1, u.getDni());
				ps.setString(2, u.getNombre());
				ps.setString(3, u.getRol());
				ps.executeUpdate();

				ps.close();
				CONNECTION.commit();
				CONNECTION.close();
				aux = u;
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return aux;
	}

	public Usuario buscarUsuario(Usuario u) {
		Connection CONNECTION = AgenteBD.dbConnector();
		Usuario aux = null;

		PreparedStatement ps;
		try {
			ps = CONNECTION.prepareStatement("select * from Usuario where dni=?");

			ps.setString(1, u.getDni());

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				aux = new Usuario();
				aux.setDni(rs.getString("dni"));
				aux.setNombre(rs.getString("nombre"));
				aux.setRol(rs.getString("rol"));
			}
			rs.close();
			ps.close();
			CONNECTION.commit();
			CONNECTION.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return aux;
	}

	public Ayuntamiento buscarAyuntamiento(String cp) {
		Connection CONNECTION = AgenteBD.dbConnector();
		Ayuntamiento aux = null;

		PreparedStatement ps;
		try {
			ps = CONNECTION.prepareStatement("select * from Ayuntamiento where cp=?");

			ps.setString(1, cp);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				aux = new Ayuntamiento();
				aux.setCp(rs.getString("cp"));
				aux.setLocalidad(rs.getString("localidad"));
				aux.setProvincia(rs.getString("provincia"));
			}
			rs.close();
			ps.close();
			CONNECTION.commit();
			CONNECTION.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return aux;
	}

	public static List<Usuario> selectAllUsers() {
		Connection CONNECTION = AgenteBD.dbConnector();
		List<Usuario> list = new ArrayList<Usuario>();
		Statement stmt = null;

		try {
			stmt = CONNECTION.createStatement();
			ResultSet rs = stmt.executeQuery("select * from Usuario");

			while (rs.next()) {

				Usuario u = new Usuario();
				u.setDni(rs.getString("dni"));
				u.setNombre(rs.getString("nombre"));
				u.setRol(rs.getString("rol"));
				list.add(u);
			}

			rs.close();
			stmt.close();
			CONNECTION.commit();
			CONNECTION.close();

		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}

		return list;
	}

	public static boolean checkTokens(Usuario u) {
		boolean noEmptyTokens = true;
		List<String> atr = new ArrayList<>();
		if (u instanceof Ciudadano) {
			atr.add(u.getDni());
			atr.add(((Ciudadano) u).getEmail());
			atr.add(u.getNombre());
			atr.add(u.getRol());
			atr.add(((Ciudadano) u).getNTarjetaSanitaria());
		} else {
			atr.add(u.getDni());
			atr.add(u.getNombre());
			atr.add(u.getRol());
			atr.add(((Sanitario) u).getNSanitario());
		}
		for (String str : atr) {
			if (str.isEmpty() || str.isBlank()) {
				noEmptyTokens = false;
			}
		}

		return noEmptyTokens;
	}

	public ActionListener btnVivienda() {

		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enableElementsHome(true);
			}

		};
	}

	public ActionListener btnAnadirVivienda() {

		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!comprobarVivienda()) {
					String dni_resp;
					if (IU_Usuario.getRdbtnRespSi().isSelected()) {
						dni_resp = IU_Usuario.getTxtDni().getText();
					} else {
						dni_resp = IU_Usuario.getTxtResponsable().getText();
					}
					if (buscarUsuario(new Usuario(dni_resp, "", "")) != null
							|| IU_Usuario.getRdbtnRespSi().isSelected()) {
						Vivienda vivenda = new Vivienda(null,
								new Responsable(dni_resp, IU_Usuario.getTxtNombre().getText(),
										IU_Usuario.getTxtEmail().getText(), "Ciudadano/Responsable"),
								IU_Usuario.getTxtDireccion().getText(),
								IU_Usuario.getcBTipo().getSelectedItem().toString());
						Ayuntamiento ay = new Ayuntamiento(IU_Usuario.getTxtCodigoPostal().getText(),
								IU_Usuario.getTxtLocalidad().getText(), IU_Usuario.getTxtProvincia().getText());
						listaVivienda.add(vivenda);
						listaAyuntamiento.add(ay);
						actualizarTabla();
						limpiarCampos(1);
					} else {
						JOptionPane.showMessageDialog(null,
								"El responsable no está creado en la base de datos. \nNofiqueselo y que le añada a la vivienda.",
								"ERROR!", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Hay algún campo vacío.", "ERROR!", JOptionPane.ERROR_MESSAGE);
				}
			}

		};
	}

	public ActionListener btnVolver() {

		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enableElementsHome(false);
				if (IU_Usuario.getRdbtnRespSi().isSelected()) {
					IU_Usuario.getLblNTarjeta().setVisible(false);
					IU_Usuario.getTxtNTarjeta().setVisible(false);
				}
			}

		};
	}

	public ItemListener rdbtnResponsableNo() {

		return new ItemListener() {
			public void itemStateChanged(ItemEvent e) {

				if (IU_Usuario.getRdbtnRespNo().isSelected()) {
					IU_Usuario.getLblDniResponsable().setVisible(true);
					IU_Usuario.getTxtResponsable().setVisible(true);
					IU_Usuario.getRdbtnRespSi().setSelected(false);
				} else {
					IU_Usuario.getLblDniResponsable().setVisible(false);
					IU_Usuario.getTxtResponsable().setVisible(false);
					IU_Usuario.getRdbtnRespSi().setSelected(true);
				}

			}
		};
	}

	public ItemListener rdbtnResponsableSi() {

		return new ItemListener() {
			public void itemStateChanged(ItemEvent e) {

				if (!IU_Usuario.getRdbtnRespSi().isSelected()) {
					IU_Usuario.getLblDniResponsable().setVisible(true);
					IU_Usuario.getTxtResponsable().setVisible(true);
					IU_Usuario.getRdbtnRespNo().setSelected(true);
				} else {
					IU_Usuario.getLblDniResponsable().setVisible(false);
					IU_Usuario.getTxtResponsable().setVisible(false);
					IU_Usuario.getRdbtnRespNo().setSelected(false);
				}

			}
		};
	}

	public void enableElementsHome(boolean visible) {
		if (visible) {
			IU_Usuario.getFrmCovidlandiak().setBounds(100, 100, 1059, 795);
			IU_Usuario.getFrmCovidlandiak()
					.setTitle("COVIDLANDIA 2K19 - Registro de Usuario. Introduzca las viviendas.");
		} else {
			IU_Usuario.getFrmCovidlandiak().setBounds(100, 100, 592, 555);
			IU_Usuario.getFrmCovidlandiak().setTitle("COVIDLANDIA 2K19 - Registro de Usuario.");
			IU_Usuario.getLblDniResponsable().setVisible(visible);
			IU_Usuario.getTxtResponsable().setVisible(visible);
		}

		IU_Usuario.getFrmCovidlandiak().setLocationRelativeTo(null);
		IU_Usuario.getLblTipoVivienda().setVisible(visible);
		IU_Usuario.getcBTipo().setVisible(visible);
		IU_Usuario.getLblDireccinCompleta().setVisible(visible);
		IU_Usuario.getTxtDireccion().setVisible(visible);
		IU_Usuario.getLblLocalidad().setVisible(visible);
		IU_Usuario.getTxtLocalidad().setVisible(visible);
		IU_Usuario.getLblProvincia().setVisible(visible);
		IU_Usuario.getTxtProvincia().setVisible(visible);
		IU_Usuario.getLblCdigoPostal().setVisible(visible);
		IU_Usuario.getTxtCodigoPostal().setVisible(visible);
		IU_Usuario.getLblResponsablePr().setVisible(visible);
		IU_Usuario.getRdbtnRespSi().setVisible(visible);
		IU_Usuario.getRdbtnRespNo().setVisible(visible);
		IU_Usuario.getTable().setVisible(visible);
		IU_Usuario.getScrollPane().setVisible(visible);
		IU_Usuario.getBtnVolver().setVisible(visible);
		IU_Usuario.getBtnAadir().setVisible(visible);

		IU_Usuario.getLblDNI().setVisible(!visible);
		IU_Usuario.getTxtDni().setVisible(!visible);
		IU_Usuario.getLblNombre().setVisible(!visible);
		IU_Usuario.getTxtNombre().setVisible(!visible);
		IU_Usuario.getLblRol().setVisible(!visible);
		IU_Usuario.getcBRol().setVisible(!visible);
		IU_Usuario.getBtnRegistro().setVisible(!visible);
		IU_Usuario.getLblEmail().setVisible(!visible);
		IU_Usuario.getTxtEmail().setVisible(!visible);
		IU_Usuario.getLblNTarjeta().setVisible(!visible);
		IU_Usuario.getTxtNTarjeta().setVisible(!visible);
		IU_Usuario.getBtnVivienda().setVisible(!visible);
	}

	public void actualizarTabla() {
		DefaultTableModel modelo = new DefaultTableModel();
		int i = 0;
		if (modelo.getColumnCount() == 0) {
			modelo.addColumn("Tipo");
			modelo.addColumn("Dirección");
			modelo.addColumn("CP");
			modelo.addColumn("Localidad");
			modelo.addColumn("Provincia");
		}
		IU_Usuario.getTable().setModel(modelo);
		for (Vivienda v : listaVivienda) {
			String[] datosV = new String[5];
			datosV[0] = v.getTipo();
			datosV[1] = v.getDireccion();
			datosV[2] = listaAyuntamiento.get(i).getCp();
			datosV[3] = listaAyuntamiento.get(i).getLocalidad();
			datosV[4] = listaAyuntamiento.get(i).getProvincia();
			i++;
			modelo.addRow(datosV);
		}

		IU_Usuario.getTable().setModel(modelo);
	}

	public boolean comprobarVivienda() {
		boolean emptyTokens = false;
		if (IU_Usuario.getcBTipo().getSelectedItem().toString().isEmpty()
				|| IU_Usuario.getcBTipo().getSelectedItem().toString().isBlank()) {
			emptyTokens = true;
		}
		if (IU_Usuario.getTxtDireccion().getText().isEmpty() || IU_Usuario.getTxtDireccion().getText().isBlank()) {
			emptyTokens = true;
		}
		if (IU_Usuario.getTxtCodigoPostal().getText().isEmpty()
				|| IU_Usuario.getTxtCodigoPostal().getText().isBlank()) {
			emptyTokens = true;
		}
		if (IU_Usuario.getTxtLocalidad().getText().isEmpty() || IU_Usuario.getTxtLocalidad().getText().isBlank()) {
			emptyTokens = true;
		}
		if (IU_Usuario.getTxtProvincia().getText().isEmpty() || IU_Usuario.getTxtProvincia().getText().isBlank()) {
			emptyTokens = true;
		}
		String dni_resp;
		if (IU_Usuario.getRdbtnRespSi().isSelected()) {
			dni_resp = IU_Usuario.getTxtDni().getText();
		} else {
			dni_resp = IU_Usuario.getTxtResponsable().getText();
		}
		if (dni_resp.isEmpty() || dni_resp.isBlank()) {
			emptyTokens = true;
		}
		return emptyTokens;

	}

	public void limpiarCampos(int a) {
		
		if (a == 0) {
			listaAyuntamiento.clear();
			listaVivienda.clear();
			actualizarTabla();

			IU_Usuario.getTxtDireccion().setText("");
			IU_Usuario.getTxtLocalidad().setText("");
			IU_Usuario.getTxtProvincia().setText("");
			IU_Usuario.getTxtCodigoPostal().setText("");
			IU_Usuario.getTxtDni().setText("");
			IU_Usuario.getTxtNombre().setText("");
			IU_Usuario.getTxtEmail().setText("");
			IU_Usuario.getTxtNTarjeta().setText("");
			IU_Usuario.getTxtNSanitario().setText("");
			IU_Usuario.getTxtResponsable().setText("");
			IU_Usuario.getcBRol().setSelectedIndex(0);
			IU_Usuario.getcBTipo().setSelectedIndex(0);
		}else {
			IU_Usuario.getTxtDireccion().setText("");
			IU_Usuario.getTxtLocalidad().setText("");
			IU_Usuario.getTxtProvincia().setText("");
			IU_Usuario.getTxtCodigoPostal().setText("");
			IU_Usuario.getTxtResponsable().setText("");
			IU_Usuario.getcBTipo().setSelectedIndex(0);
		}
		
	}

}