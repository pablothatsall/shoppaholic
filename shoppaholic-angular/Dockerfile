### BUILD ###

FROM node:8-alpine as builder

COPY . /shoppaholic-angular

COPY package.json /shoppaholic-angular
COPY proxy.conf.json /shoppaholic-angular

WORKDIR /shoppaholic-angular

RUN npm install
RUN $(npm bin)/ng build

### SETUP ###

FROM nginx:1.13.3-alpine

COPY --from=builder /shoppaholic-angular/dist/* /usr/share/nginx/html/
COPY --from=builder /shoppaholic-angular/src/assets/ /usr/share/nginx/html/assets/

EXPOSE 80
