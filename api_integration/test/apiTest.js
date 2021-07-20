var chai = require('chai'),
    chaiHttp = require('chai-http');
chai.use(chaiHttp);
var expect = chai.expect;

describe('Api Test', () => {
    it('Get something', function(done)  {
        chai.request('https://jsonplaceholder.typicode.com')
        .get('/todos')
        .end((err,res) => {
            expect(res).to.have.status(200);
            chai.request('https://jsonplaceholder.typicode.com')
            .get(`/todos/${res.body[2].id}`)
            .end((err,res) => {
                expect(res.body.id).to.be.equal(3);
            })

        })
        done();
    })
})