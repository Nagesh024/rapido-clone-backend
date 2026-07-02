import http from 'k6/http';
import { check } from 'k6';

export const options = {

    scenarios: {

        enterprise_load: {

            executor: 'constant-arrival-rate',

			rate: 50000,

			timeUnit: '1m',

			duration: '2m',

			preAllocatedVUs: 5000,

			maxVUs: 100000
        }
    },

    thresholds: {

        http_req_duration: [

            'p(95)<200',

            'p(99)<400'
        ],

        http_req_failed: [

            'rate<0.01'
        ]
    }
};

export default function () {

    const res =	http.get(
	    'http://localhost:8088/admin/dashboard/summary'
	);

    check(res, {
        'status is 200': (r) => r.status === 200,
    });
}