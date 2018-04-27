### BUILD ###

FROM node:8-alpine as builder

COPY . /shoppaholic-angular


WORKDIR /shoppaholic-angular

RUN npm install
RUN $(npm bin)/ng build

### SETUP ###

FROM nginx:1.13.3-alpine

COPY --from=builder /shoppaholic-angular/dist/* /usr/share/nginx/html/
COPY --from=builder /shoppaholic-angular/src/assets/ /usr/share/nginx/html/assets/

RUN rm -v /etc/nginx/nginx.conf
COPY --from=builder /shoppaholic-angular/nginx.conf /etc/nginx/

EXPOSE 80
