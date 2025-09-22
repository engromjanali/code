
class WModel {
    Location location;
    Current current;

    WModel({
        required this.location,
        required this.current,
    });

    WModel copyWith({
        Location? location,
        Current? current,
    }) => 
        WModel(
            location: location ?? this.location,
            current: current ?? this.current,
        );

    factory WModel.fromJson(Map<String, dynamic> json) => WModel(
        location: Location.fromJson(json["location"]),
        current: Current.fromJson(json["current"]),
    );

    Map<String, dynamic> toJson() => {
        "location": location.toJson(),
        "current": current.toJson(),
    };
}

class Current {
    int lastUpdatedEpoch;
    String lastUpdated;
    double tempC;
    double tempF;
    int isDay;
    Condition condition;
    double windMph;
    double windKph;
    int windDegree;
    String windDir;
    double pressureMb;
    double pressureIn;
    double precipMm;
    double precipIn;
    int humidity;
    int cloud;
    double feelslikeC;
    double feelslikeF;
    double windchillC;
    double windchillF;
    double heatindexC;
    double heatindexF;
    double dewpointC;
    double dewpointF;
    double visKm;
    double visMiles;
    double uv;
    double gustMph;
    double gustKph;
    int shortRad;
    int diffRad;
    int dni;
    int gti;

    Current({
        required this.lastUpdatedEpoch,
        required this.lastUpdated,
        required this.tempC,
        required this.tempF,
        required this.isDay,
        required this.condition,
        required this.windMph,
        required this.windKph,
        required this.windDegree,
        required this.windDir,
        required this.pressureMb,
        required this.pressureIn,
        required this.precipMm,
        required this.precipIn,
        required this.humidity,
        required this.cloud,
        required this.feelslikeC,
        required this.feelslikeF,
        required this.windchillC,
        required this.windchillF,
        required this.heatindexC,
        required this.heatindexF,
        required this.dewpointC,
        required this.dewpointF,
        required this.visKm,
        required this.visMiles,
        required this.uv,
        required this.gustMph,
        required this.gustKph,
        required this.shortRad,
        required this.diffRad,
        required this.dni,
        required this.gti,
    });

    Current copyWith({
        int? lastUpdatedEpoch,
        String? lastUpdated,
        double? tempC,
        double? tempF,
        int? isDay,
        Condition? condition,
        double? windMph,
        double? windKph,
        int? windDegree,
        String? windDir,
        double? pressureMb,
        double? pressureIn,
        double? precipMm,
        double? precipIn,
        int? humidity,
        int? cloud,
        double? feelslikeC,
        double? feelslikeF,
        double? windchillC,
        double? windchillF,
        double? heatindexC,
        double? heatindexF,
        double? dewpointC,
        double? dewpointF,
        double? visKm,
        double? visMiles,
        double? uv,
        double? gustMph,
        double? gustKph,
        int? shortRad,
        int? diffRad,
        int? dni,
        int? gti,
    }) => 
        Current(
            lastUpdatedEpoch: lastUpdatedEpoch ?? this.lastUpdatedEpoch,
            lastUpdated: lastUpdated ?? this.lastUpdated,
            tempC: tempC ?? this.tempC,
            tempF: tempF ?? this.tempF,
            isDay: isDay ?? this.isDay,
            condition: condition ?? this.condition,
            windMph: windMph ?? this.windMph,
            windKph: windKph ?? this.windKph,
            windDegree: windDegree ?? this.windDegree,
            windDir: windDir ?? this.windDir,
            pressureMb: pressureMb ?? this.pressureMb,
            pressureIn: pressureIn ?? this.pressureIn,
            precipMm: precipMm ?? this.precipMm,
            precipIn: precipIn ?? this.precipIn,
            humidity: humidity ?? this.humidity,
            cloud: cloud ?? this.cloud,
            feelslikeC: feelslikeC ?? this.feelslikeC,
            feelslikeF: feelslikeF ?? this.feelslikeF,
            windchillC: windchillC ?? this.windchillC,
            windchillF: windchillF ?? this.windchillF,
            heatindexC: heatindexC ?? this.heatindexC,
            heatindexF: heatindexF ?? this.heatindexF,
            dewpointC: dewpointC ?? this.dewpointC,
            dewpointF: dewpointF ?? this.dewpointF,
            visKm: visKm ?? this.visKm,
            visMiles: visMiles ?? this.visMiles,
            uv: uv ?? this.uv,
            gustMph: gustMph ?? this.gustMph,
            gustKph: gustKph ?? this.gustKph,
            shortRad: shortRad ?? this.shortRad,
            diffRad: diffRad ?? this.diffRad,
            dni: dni ?? this.dni,
            gti: gti ?? this.gti,
        );

    factory Current.fromJson(Map<String, dynamic> json) => Current(
        lastUpdatedEpoch: json["last_updated_epoch"],
        lastUpdated: json["last_updated"],
        tempC: json["temp_c"],
        tempF: json["temp_f"]?.toDouble(),
        isDay: json["is_day"],
        condition: Condition.fromJson(json["condition"]),
        windMph: json["wind_mph"]?.toDouble(),
        windKph: json["wind_kph"]?.toDouble(),
        windDegree: json["wind_degree"],
        windDir: json["wind_dir"],
        pressureMb: json["pressure_mb"],
        pressureIn: json["pressure_in"]?.toDouble(),
        precipMm: json["precip_mm"],
        precipIn: json["precip_in"],
        humidity: json["humidity"],
        cloud: json["cloud"],
        feelslikeC: json["feelslike_c"]?.toDouble(),
        feelslikeF: json["feelslike_f"]?.toDouble(),
        windchillC: json["windchill_c"],
        windchillF: json["windchill_f"]?.toDouble(),
        heatindexC: json["heatindex_c"]?.toDouble(),
        heatindexF: json["heatindex_f"]?.toDouble(),
        dewpointC: json["dewpoint_c"]?.toDouble(),
        dewpointF: json["dewpoint_f"]?.toDouble(),
        visKm: json["vis_km"],
        visMiles: json["vis_miles"],
        uv: json["uv"],
        gustMph: json["gust_mph"]?.toDouble(),
        gustKph: json["gust_kph"]?.toDouble(),
        shortRad: json["short_rad"],
        diffRad: json["diff_rad"],
        dni: json["dni"],
        gti: json["gti"],
    );

    Map<String, dynamic> toJson() => {
        "last_updated_epoch": lastUpdatedEpoch,
        "last_updated": lastUpdated,
        "temp_c": tempC,
        "temp_f": tempF,
        "is_day": isDay,
        "condition": condition.toJson(),
        "wind_mph": windMph,
        "wind_kph": windKph,
        "wind_degree": windDegree,
        "wind_dir": windDir,
        "pressure_mb": pressureMb,
        "pressure_in": pressureIn,
        "precip_mm": precipMm,
        "precip_in": precipIn,
        "humidity": humidity,
        "cloud": cloud,
        "feelslike_c": feelslikeC,
        "feelslike_f": feelslikeF,
        "windchill_c": windchillC,
        "windchill_f": windchillF,
        "heatindex_c": heatindexC,
        "heatindex_f": heatindexF,
        "dewpoint_c": dewpointC,
        "dewpoint_f": dewpointF,
        "vis_km": visKm,
        "vis_miles": visMiles,
        "uv": uv,
        "gust_mph": gustMph,
        "gust_kph": gustKph,
        "short_rad": shortRad,
        "diff_rad": diffRad,
        "dni": dni,
        "gti": gti,
    };
}

class Condition {
    String text;
    String icon;
    int code;

    Condition({
        required this.text,
        required this.icon,
        required this.code,
    });

    Condition copyWith({
        String? text,
        String? icon,
        int? code,
    }) => 
        Condition(
            text: text ?? this.text,
            icon: icon ?? this.icon,
            code: code ?? this.code,
        );

    factory Condition.fromJson(Map<String, dynamic> json) => Condition(
        text: json["text"],
        icon: json["icon"],
        code: json["code"],
    );

    Map<String, dynamic> toJson() => {
        "text": text,
        "icon": icon,
        "code": code,
    };
}

class Location {
    String name;
    String region;
    String country;
    double lat;
    double lon;
    String tzId;
    int localtimeEpoch;
    String localtime;

    Location({
        required this.name,
        required this.region,
        required this.country,
        required this.lat,
        required this.lon,
        required this.tzId,
        required this.localtimeEpoch,
        required this.localtime,
    });

    Location copyWith({
        String? name,
        String? region,
        String? country,
        double? lat,
        double? lon,
        String? tzId,
        int? localtimeEpoch,
        String? localtime,
    }) => 
        Location(
            name: name ?? this.name,
            region: region ?? this.region,
            country: country ?? this.country,
            lat: lat ?? this.lat,
            lon: lon ?? this.lon,
            tzId: tzId ?? this.tzId,
            localtimeEpoch: localtimeEpoch ?? this.localtimeEpoch,
            localtime: localtime ?? this.localtime,
        );

    factory Location.fromJson(Map<String, dynamic> json) => Location(
        name: json["name"],
        region: json["region"],
        country: json["country"],
        lat: json["lat"]?.toDouble(),
        lon: json["lon"]?.toDouble(),
        tzId: json["tz_id"],
        localtimeEpoch: json["localtime_epoch"],
        localtime: json["localtime"],
    );

    Map<String, dynamic> toJson() => {
        "name": name,
        "region": region,
        "country": country,
        "lat": lat,
        "lon": lon,
        "tz_id": tzId,
        "localtime_epoch": localtimeEpoch,
        "localtime": localtime,
    };
}





// {
//     "location": {
//         "name": "Dhaka",
//         "region": "",
//         "country": "Bangladesh",
//         "lat": 23.7231,
//         "lon": 90.4086,
//         "tz_id": "Asia/Dhaka",
//         "localtime_epoch": 1758558577,
//         "localtime": "2025-09-22 22:29"
//     },
//     "current": {
//         "last_updated_epoch": 1758557700,
//         "last_updated": "2025-09-22 22:15",
//         "temp_c": 27.0,
//         "temp_f": 80.6,
//         "is_day": 0,
//         "condition": {
//             "text": "Partly Cloudy",
//             "icon": "//cdn.weatherapi.com/weather/64x64/night/116.png",
//             "code": 1003
//         },
//         "wind_mph": 5.4,
//         "wind_kph": 8.6,
//         "wind_degree": 153,
//         "wind_dir": "SSE",
//         "pressure_mb": 1006.0,
//         "pressure_in": 29.69,
//         "precip_mm": 0.0,
//         "precip_in": 0.0,
//         "humidity": 84,
//         "cloud": 37,
//         "feelslike_c": 30.8,
//         "feelslike_f": 87.4,
//         "windchill_c": 27.0,
//         "windchill_f": 80.6,
//         "heatindex_c": 30.8,
//         "heatindex_f": 87.4,
//         "dewpoint_c": 24.1,
//         "dewpoint_f": 75.4,
//         "vis_km": 10.0,
//         "vis_miles": 6.0,
//         "uv": 0.0,
//         "gust_mph": 8.2,
//         "gust_kph": 13.1,
//         "short_rad": 0,
//         "diff_rad": 0,
//         "dni": 0,
//         "gti": 0
//     }
// }