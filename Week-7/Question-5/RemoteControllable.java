public interface RemoteControllable {
    String connect(String appId);

    static void connectAll(RemoteControllable[] items, String appId) {
        for (int i = 0; i < items.length; i++) {
            System.out.println(items[i].connect(appId));
        }
    }
}
