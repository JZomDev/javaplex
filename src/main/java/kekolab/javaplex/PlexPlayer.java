package kekolab.javaplex;

public class PlexPlayer extends BaseItem {
    private String address;
    private String device;
    private String machineIdentifier;
    private String model;
    private String platform;
    private String platformVersion;
    private String product;
    private String profile;
    private String remotePublicAddress;
    private String state;
    private String title;
    private String vendor;
    private String version;
    private Boolean local;
    private Boolean relayed;
    private Boolean secure;
    private Integer userID;

    @Override
    protected void clear() {
        super.clear();
        address = null;
        device = null;
        machineIdentifier = null;
        model = null;
        platform = null;
        platformVersion = null;
        product = null;
        profile = null;
        remotePublicAddress = null;
        state = null;
        title = null;
        vendor = null;
        version = null;
        local = null;
        relayed = null;
        secure = null;
        userID = null;
    }

    @Override
    protected void update(BaseItem source) {
        super.update(source);
        if (source instanceof PlexPlayer player) {
            address = player.address;
            device = player.device;
            machineIdentifier = player.machineIdentifier;
            model = player.model;
            platform = player.platform;
            platformVersion = player.platformVersion;
            product = player.product;
            profile = player.profile;
            remotePublicAddress = player.remotePublicAddress;
            state = player.state;
            title = player.title;
            vendor = player.vendor;
            version = player.version;
            local = player.local;
            relayed = player.relayed;
            secure = player.secure;
            userID = player.userID;
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getMachineIdentifier() {
        return machineIdentifier;
    }

    public void setMachineIdentifier(String machineIdentifier) {
        this.machineIdentifier = machineIdentifier;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getPlatformVersion() {
        return platformVersion;
    }

    public void setPlatformVersion(String platformVersion) {
        this.platformVersion = platformVersion;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getRemotePublicAddress() {
        return remotePublicAddress;
    }

    public void setRemotePublicAddress(String remotePublicAddress) {
        this.remotePublicAddress = remotePublicAddress;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Boolean getLocal() {
        return local;
    }

    public void setLocal(Boolean local) {
        this.local = local;
    }

    public Boolean getRelayed() {
        return relayed;
    }

    public void setRelayed(Boolean relayed) {
        this.relayed = relayed;
    }

    public Boolean getSecure() {
        return secure;
    }

    public void setSecure(Boolean secure) {
        this.secure = secure;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

}
