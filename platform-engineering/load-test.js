import http from 'k6/http';

export default function () {
    http.get('http://localhost:8088/actuator/health');
}