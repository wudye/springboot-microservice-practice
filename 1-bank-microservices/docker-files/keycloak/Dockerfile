FROM quay.io/keycloak/keycloak:23.0.7

# Make the realm configuration available for import
COPY ./realm-export.json /opt/keycloak_import/

RUN /opt/keycloak/bin/kv.sh import --optimized --file /opt/keycloak_import/realm-export.json

EXPOSE 8080

CMD ["start-dev"]