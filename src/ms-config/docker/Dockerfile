#--------------------------.
# GIT                      |
#--------------------------'
FROM alpine/git as clone
# Set the working directory
WORKDIR /app
# Add Json lastest SHA commit to check update for the clone cmd
ADD https://api.github.com/repos/vyjorg/LPDM/git/refs/heads/develop/msconfig /app
# Clone the Github repository
RUN git clone -b develop/msconfig https://github.com/vyjorg/LPDM.git

#--------------------------.
# MAVEN                    |
#--------------------------'
FROM maven:3.6-jdk-8-alpine as builder
# Set the working directory
WORKDIR /app
# Copy data from the cloned repository to the working directory
COPY --from=clone /app/LPDM/src/ms-config /app
# Build the project
RUN mvn clean package

CMD ["java", "-jar", "target/ms-config-0.0.1-SNAPSHOT.jar"]