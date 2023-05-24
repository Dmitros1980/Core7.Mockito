
public interface GeoService {

    Location byIp(String ip);

    Location byCoordinates(double latitude, double longitude);
}
