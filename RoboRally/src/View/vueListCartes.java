package View;

	import java.awt.Component;
	import java.awt.Dimension;
	import java.awt.Font;
	import java.net.URL;
	import java.util.HashMap;
	import java.util.Map;
	import javax.swing.DefaultListCellRenderer;
	import javax.swing.ImageIcon;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JList;
	import javax.swing.JScrollPane;
	import javax.swing.SwingUtilities;
	public class vueListCartes {


		private final Map<String, ImageIcon> imageMap;

		public vueListCartes() {
			String[] nameList = {"Mario", "Luigi", "Bowser", "Koopa", "Princess"};
			imageMap = createImageMap(nameList);
			JList list = new JList(nameList);
			list.setCellRenderer(new MarioListRenderer());

			JScrollPane scroll = new JScrollPane(list);
			scroll.setPreferredSize(new Dimension(300, 400));

			JFrame frame = new JFrame();
			frame.add(scroll);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.pack();
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
		}

		public class vueListCartesRenderer extends DefaultListCellRenderer {

			Font font = new Font("helvitica", Font.BOLD, 24);

			@Override
			public Component getListCellRendererComponent(
					JList list, Object value, int index,
					boolean isSelected, boolean cellHasFocus) {

				JLabel label = (JLabel) super.getListCellRendererComponent(
						list, value, index, isSelected, cellHasFocus);
				label.setIcon(imageMap.get((String) value));
				label.setHorizontalTextPosition(JLabel.RIGHT);
				label.setFont(font);
				return label;
			}
		}

		private Map<String, ImageIcon> createImageMap(String[] list) {
			Map<String, ImageIcon> map = new HashMap<>();
			try {
				map.put("Mario", new ImageIcon(new URL("http://i.stack.imgur.com/NCsHu.png")));
				map.put("Luigi", new ImageIcon(new URL("http://i.stack.imgur.com/UvHN4.png")));
				map.put("Bowser", new ImageIcon(new URL("http://i.stack.imgur.com/s89ON.png")));
				map.put("Koopa", new ImageIcon(new URL("http://i.stack.imgur.com/QEK2o.png")));
				map.put("Princess", new ImageIcon(new URL("http://i.stack.imgur.com/f4T4l.png")));
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			return map;
		}

		public static void main(String[] args) {
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					new vueListCartes();
				}
			});
		}
	}